package org.example.domain.model;

import com.google.gson.annotations.SerializedName;
import org.example.domain.TaskState;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Task {
    @SerializedName("Description")
    private final String description;
    @SerializedName("Created")
    private final LocalDateTime creationDate;
    @SerializedName("DueDate")
    private final LocalDateTime dueDate;
    @SerializedName("CloseDate")
    private final LocalDateTime closeDate;
    @SerializedName("State")
    private TaskState state = TaskState.TODO;
    @SerializedName("Tag")
    private final String tag;
    @SerializedName("SubTasks")
    private final List<Task> subTasks;

    public Task(String description, LocalDateTime creationDate, LocalDateTime dueDate, LocalDateTime closeDate, String tag, List<Task> subTasks) {
        this.description = description;
        this.creationDate = creationDate;
        this.dueDate = dueDate;
        this.closeDate = closeDate;
        this.tag = tag;
        this.subTasks = subTasks;
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
