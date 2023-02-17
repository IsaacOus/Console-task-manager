package org.example.infrastructure.service;

import org.example.domain.model.Task;
import org.example.domain.model.TaskBuilder;
import org.example.domain.repository.TaskRepository;
import org.example.domain.service.TaskService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task addTask(String description, LocalDateTime creationDate, Optional<LocalDateTime> dueDate, Optional<LocalDateTime> closeDate, Optional<String> tag, List<Task> subTasks) {
        Task task = new TaskBuilder()
                .setDescription(description)
                .setCreationDate(creationDate)
                .dueDate(dueDate)
                .closeDate(closeDate)
                .tag(tag)
                .subTasks(subTasks)
                .getResult();

        return taskRepository.addTask(task);
    }

    @Override
    public Task updateTask(int index, Task task) {
        return this.taskRepository.updateTask(index, task);
    }

    @Override
    public boolean removeTask(int index) {
        final Task task = this.taskRepository.getTaskByIndex(index);
        return this.taskRepository.removeTask(task);
    }

    @Override
    public Task getTask(Task task) {
        return this.taskRepository.getTask(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return this.taskRepository.getAllTasks();
    }
}
