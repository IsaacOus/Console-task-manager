package org.example.domain.repository;

import org.example.domain.model.Task;

import java.util.List;

public interface TaskRepository {

    Task addTask(Task task);
    Task updateTask(Task task);
    boolean removeTask(Task task);
    Task getTask(Task task);

    List<Task> getAllTasks();

}
