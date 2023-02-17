package org.example.domain.service;

import org.example.domain.model.Task;

import java.time.OffsetDateTime;
import java.util.List;

public interface TaskService {

        Task addTask(String description, OffsetDateTime creationDate, OffsetDateTime dueDate, OffsetDateTime closeDate, String tag, List<Task> subTasks);
        Task updateTask(int index, Task task);
        boolean removeTask(int index);
        Task getTask(Task task);
        List<Task> getAllTasks();
}
