package org.example.domain.service;

import org.example.domain.model.Task;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskService {

        Task addTask(String description, LocalDateTime creationDate, LocalDateTime dueDate, LocalDateTime closeDate, String tag, List<Task> subTasks);
        Task updateTask(int index, Task task);
        boolean removeTask(int index);
        Task getTask(Task task);
        List<Task> getAllTasks();
}
