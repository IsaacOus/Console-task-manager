package org.example.domain.model;

import com.google.gson.annotations.SerializedName;
import org.example.domain.TaskState;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;

public class Task {
    @SerializedName("Description")
    private final String description;
    @SerializedName("Created")
    private final OffsetDateTime creationDate;
    @SerializedName("DueDate")
    private final OffsetDateTime dueDate;
    @SerializedName("CloseDate")
    private final OffsetDateTime closeDate;
    @SerializedName("State")
    private final TaskState state;
    @SerializedName("Tag")
    private final String tag;
    @SerializedName("SubTasks")
    private final List<Task> subTasks;

    public Task(String description, OffsetDateTime creationDate, OffsetDateTime dueDate, OffsetDateTime closeDate, TaskState state, String tag, List<Task> subTasks) {
        this.description = description;
        this.creationDate = creationDate;
        this.dueDate = dueDate;
        this.closeDate = closeDate;
        this.state = state;
        this.tag = tag;
        this.subTasks = subTasks;
    }

    public String getDescription() {
        return description;
    }

    public OffsetDateTime getCreationDate() {
        return creationDate;
    }

    public OffsetDateTime getDueDate() {
        return dueDate;
    }

    public OffsetDateTime getCloseDate() {
        return closeDate;
    }

    public TaskState getState() {
        return state;
    }

    public String getTag() {
        return tag;
    }

    public List<Task> getSubTasks() {
        return subTasks;
    }

    @Override
    public String toString() {
        return "Task{" +
                "description='" + description + '\'' +
                ", creationDate=" + creationDate +
                ", dueDate=" + dueDate +
                ", closeDate=" + closeDate +
                ", state=" + state +
                ", tag='" + tag + '\'' +
                ", subTasks=" + subTasks +
                '}';
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
