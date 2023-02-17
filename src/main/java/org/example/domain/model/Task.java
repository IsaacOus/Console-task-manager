package org.example.domain.model;

import org.example.domain.TaskState;

import java.time.LocalDateTime;
import java.util.List;

public class Task {
    private final LocalDateTime creationDate;
    private final LocalDateTime dueDate;
    private final LocalDateTime closeDate;
    private final TaskState state;
    private final List<Task> subTasks;

    public Task(LocalDateTime creationDate, LocalDateTime dueDate, LocalDateTime closeDate, TaskState state, List<Task> subTasks) {
        this.creationDate = creationDate;
        this.dueDate = dueDate;
        this.closeDate = closeDate;
        this.state = state;
        this.subTasks = subTasks;
    }
}
