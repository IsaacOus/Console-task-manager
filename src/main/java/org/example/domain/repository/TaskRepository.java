package org.example.domain.repository;

import org.example.domain.model.Task;

import java.util.List;

public interface TaskRepository {

    Task addTask(Task task);
    boolean updateTask(int index, Task task);
    boolean removeTask(Task task);
    Task getTask(Task task);
    Task getTaskByIndex(int index, List<Task> tasks);
    List<Task> getAllTasks();
}
