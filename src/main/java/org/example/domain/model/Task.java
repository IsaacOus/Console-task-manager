package org.example.domain.model;

import org.example.domain.TaskState;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Task {

    private final String description;
    private final LocalDateTime creationDate;
    private final Optional<LocalDateTime> dueDate;
    private final Optional<LocalDateTime> closeDate;
    private final TaskState state;
    private final Optional<String> tag;
    private final List<Task> subTasks;

    public static Task of(String description, LocalDateTime creationDate, Optional<LocalDateTime> dueDate, Optional<LocalDateTime> closeDate, TaskState state, Optional<String> tag, List<Task> subTasks) {
        return new Task(description, creationDate, dueDate, closeDate, state, tag, subTasks);
    }

    private Task(String description, LocalDateTime creationDate, Optional<LocalDateTime> dueDate, Optional<LocalDateTime> closeDate, TaskState state, Optional<String> tag, List<Task> subTasks) {
        this.description = description;
        this.creationDate = creationDate;
        this.dueDate = dueDate;
        this.closeDate = closeDate;
        this.state = state;
        this.tag = tag;
        this.subTasks = subTasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (!Objects.equals(description, task.description)) return false;
        if (!Objects.equals(creationDate, task.creationDate)) return false;
        if (!Objects.equals(dueDate, task.dueDate)) return false;
        if (!Objects.equals(closeDate, task.closeDate)) return false;
        if (state != task.state) return false;
        if (!Objects.equals(tag, task.tag)) return false;
        return Objects.equals(subTasks, task.subTasks);
    }

    @Override
    public int hashCode() {
        int result = description != null ? description.hashCode() : 0;
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (dueDate != null ? dueDate.hashCode() : 0);
        result = 31 * result + (closeDate != null ? closeDate.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (tag != null ? tag.hashCode() : 0);
        result = 31 * result + (subTasks != null ? subTasks.hashCode() : 0);
        return result;
    }
}
