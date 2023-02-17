package org.example.infrastructure.repository;

import org.example.application.io.Reader;
import org.example.application.io.Writer;
import org.example.domain.model.Task;
import org.example.domain.repository.TaskRepository;
import org.example.infrastructure.io.JsonFile;
import org.example.infrastructure.io.JsonFileReader;
import org.example.infrastructure.io.JsonFileWriter;

import java.util.List;

public class LocalTaskRepositoryImpl implements TaskRepository {

    private final JsonFile jsonFile = new JsonFile();
    private final Reader jsonFileReader = new JsonFileReader(jsonFile);
    private final Writer jsonFileWriter = new JsonFileWriter(jsonFile);

    @Override
    public Task addTask(Task task) {
        List<Task> tasks = this.getAllTasks();
        tasks.add(task);
        jsonFileWriter.save(tasks);
        return task;
    }

    @Override
    public Task updateTask(int index, Task task) {
        final List<Task> tasks = this.getAllTasks();
        tasks.set(index, task);
        jsonFileWriter.save(tasks);
        return tasks.get(index);
    }

    @Override
    public boolean removeTask(Task task) {
        List<Task> tasks = this.getAllTasks();
        tasks.remove(task);
        jsonFileWriter.save(tasks);
        return true;
    }

    @Override
    public Task getTask(Task task) {
        return jsonFileReader.read().stream()
                .filter(t -> t.equals(task))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Task getTaskByIndex(int index) {
        return jsonFileReader.read().get(index);
    }

    @Override
    public List<Task> getAllTasks() {
        return jsonFileReader.read();
    }

}
