package org.example.domain.model;

import org.example.domain.TaskState;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class TaskBuilder implements Builder {
    private String description;
    private LocalDateTime creationDate;
    private Optional<LocalDateTime> dueDate;
    private Optional<LocalDateTime> closeDate;
    private Optional<String> tag;
    private List<Task> subTasks;

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public void creationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public void dueDate(Optional<LocalDateTime> dueDate) {
        this.dueDate = dueDate;

    }

    @Override
    public void closeDate(Optional<LocalDateTime> closeDate) {
        this.closeDate = closeDate;

    }

    @Override
    public void tag(Optional<String> tag) {
        this.tag = tag;
    }

    @Override
    public void subTasks(List<Task> subTasks) {
        this.subTasks = subTasks;

    }

    public Task getResult() {
        return new Task(description, creationDate, dueDate, closeDate, tag, subTasks);
    }
}
