package org.example.infrastructure.repository;

import org.example.application.io.Reader;
import org.example.application.io.Writer;
import org.example.domain.model.Task;
import org.example.domain.model.TaskBuilder;
import org.example.domain.repository.TaskRepository;
import org.example.infrastructure.io.JsonFile;
import org.example.infrastructure.io.JsonFileReader;
import org.example.infrastructure.io.JsonFileWriter;

import java.util.List;

public class LocalTaskRepositoryImpl implements TaskRepository {

    private final JsonFile jsonFile = new JsonFile();
    private final Reader jsonFileReader = new JsonFileReader(jsonFile);
    private final Writer jsonFileWriter = new JsonFileWriter(jsonFile);

    private int index = 0;

    @Override
    public Task addTask(Task task) {
        final List<Task> tasks = this.getAllTasks();
        tasks.add(task);
        jsonFileWriter.save(tasks);
        return task;
    }

    @Override
    public boolean updateTask(int index, Task task) {
        this.index = 0;
        List<Task> tasks = this.getAllTasks();
        tasks = this.updateTaskByIndex(index, tasks, task);
        return jsonFileWriter.save(tasks);
    }

    @Override
    public boolean removeTask(Task task) {
        final List<Task> tasks = this.getAllTasks();
        boolean result = tasks.remove(task);
        jsonFileWriter.save(tasks);
        return result;
    }

    @Override
    public Task getTask(Task task) {
        return jsonFileReader.read().stream()
                .filter(t -> t.equals(task))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Task getTaskByIndex(int index, List<Task> tasks) {
        this.index = 0;
        return findByIndex(index, tasks);
    }

    @Override
    public List<Task> getAllTasks() {
        return jsonFileReader.read();
    }

    private Task findByIndex(int index, List<Task> tasks) {
        Task matchingTask = null;
        for (Task task : tasks) {
            if (task.getSubTasks() != null && !task.getSubTasks().isEmpty()) {
                matchingTask = findByIndex(index, task.getSubTasks());
            }
            if (this.index == index) {
                return task;
            }
            this.index++;
        }
        return matchingTask;
    }

    private List<Task> updateTaskByIndex(int index, List<Task> tasks, Task updatedTask) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getSubTasks() != null && !tasks.get(i).getSubTasks().isEmpty()) {
                tasks.set(i, new TaskBuilder().updateSubTasks(tasks.get(i), updateTaskByIndex(index, tasks.get(i).getSubTasks(), updatedTask)));
            }
            if (this.index == index) {
                tasks.set(i, updatedTask);
            }
            this.index++;
        }
        return tasks;
    }
}
