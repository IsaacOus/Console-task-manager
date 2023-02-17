package org.example.domain.service;

import org.example.domain.model.Task;
import org.example.domain.repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TaskService {

        Task addTask(String description, LocalDateTime creationDate, Optional<LocalDateTime> dueDate, Optional<LocalDateTime> closeDate, Optional<String> tag, List<Task> subTasks);
        Task updateTask();
        boolean removeTask();
        Task getTask();
        List<Task> getAllTasks();
}
