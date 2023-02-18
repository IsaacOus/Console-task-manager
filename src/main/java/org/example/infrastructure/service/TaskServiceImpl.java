package org.example.infrastructure.service;

import org.example.domain.model.Task;
import org.example.domain.model.TaskBuilder;
import org.example.domain.repository.TaskRepository;
import org.example.domain.service.TaskService;

import java.time.OffsetDateTime;
import java.util.List;

public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task addTask(String description, OffsetDateTime creationDate, OffsetDateTime dueDate, OffsetDateTime closeDate, String tag, List<Task> subTasks) {
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
    public boolean updateTask(int index, String description, OffsetDateTime dueDate, String status) {
        Task task = this.taskRepository.getTaskByIndex(index, this.getAllTasks());
        if (description.isBlank()) {
            description = task.getDescription();
        }
        if (dueDate == null) {
            dueDate = task.getDueDate();
        }
        if (status.isBlank()) {
            status = task.getState().getName();
        }
        Task updatedTask = new TaskBuilder()
                .setDescription(description)
                .setCreationDate(task.getCreationDate())
                .dueDate(dueDate)
                .closeDate(task.getCloseDate())
                .tag(task.getTag())
                .subTasks(task.getSubTasks())
                .state(status)
                .getResult();
        return this.taskRepository.updateTask(index, updatedTask);
    }

    @Override
    public boolean removeTask(int index) {
        final Task task = this.taskRepository.getTaskByIndex(index, this.getAllTasks());
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
