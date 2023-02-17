package org.example.domain.model;

import java.time.OffsetDateTime;
import java.util.List;

public class TaskBuilder {
    private String description;
    private OffsetDateTime creationDate;
    private OffsetDateTime dueDate;
    private OffsetDateTime closeDate;
    private String tag;
    private List<Task> subTasks;

    public TaskBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public TaskBuilder setCreationDate(OffsetDateTime creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public TaskBuilder dueDate(OffsetDateTime dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public TaskBuilder closeDate(OffsetDateTime closeDate) {
        this.closeDate = closeDate;
        return this;
    }

    public TaskBuilder tag(String tag) {
        this.tag = tag;
        return this;
    }

    public TaskBuilder subTasks(List<Task> subTasks) {
        this.subTasks = subTasks;
        return this;
    }

    public Task getResult() {
        return new Task(description, creationDate, dueDate, closeDate, tag, subTasks);
    }
}
