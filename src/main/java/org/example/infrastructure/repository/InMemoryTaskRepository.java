package org.example.infrastructure.repository;


import org.example.domain.model.Task;
import org.example.domain.model.TaskBuilder;
import org.example.domain.repository.TaskRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class InMemoryTaskRepository implements TaskRepository {

    private final List<Task> tasks;

    public InMemoryTaskRepository() {
        this.tasks = new ArrayList<>();
    }

    @Override
    public Task addTask(Task task) {
        int index = tasks.size();
        Task newTask = new TaskBuilder()
                .setDescription(task.getDescription())
                .setCreationDate(task.getCreationDate())
                .dueDate(task.getDueDate())
                .closeDate(task.getCloseDate())
                .state(task.getState().getName())
                .tag(task.getTag())
                .subTasks(task.getSubTasks())
                .getResult();
        tasks.add(newTask);
        return newTask;
    }

    @Override
    public boolean updateTask(int index, Task task) {
        if (index >= tasks.size()) {
            return false;
        }
        Task updatedTask = new TaskBuilder()
                .setDescription(task.getDescription())
                .setCreationDate(task.getCreationDate())
                .dueDate(task.getDueDate())
                .closeDate(task.getCloseDate())
                .state(task.getState().getName())
                .tag(task.getTag())
                .subTasks(task.getSubTasks())
                .getResult();
        tasks.set(index, updatedTask);
        return true;
    }

    @Override
    public boolean removeTask(Task task) {
        return tasks.remove(task);
    }

    @Override
    public Task getTask(Task task) {
        for (Task t : tasks) {
            if (t.equals(task)) {
                return t;
            }
        }
        return null;
    }

    @Override
    public List<Task> getAllTasks() {
        return Collections.unmodifiableList(tasks);
    }

    @Override
    public Task getTaskByIndex(int index, List<Task> taskList) {
        if (index < 0 || index >= taskList.size()) {
            return null;
        }
        return taskList.get(index);
    }
}
