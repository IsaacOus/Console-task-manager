package org.example.domain.model;

import java.util.Objects;

public class TaskWrapper {
    private final int index;
    private final Task task;
    private final int numberOfParentTasks;

    public TaskWrapper(int index, Task task, int numberOfParentTasks) {
        this.index = index;
        this.task = task;
        this.numberOfParentTasks = numberOfParentTasks;
    }

    public int getIndex() {
        return index;
    }

    public Task getTask() {
        return task;
    }

    public int getNumberOfParentTasks() {
        return numberOfParentTasks;
    }

    @Override
    public String toString() {
        return "TaskWrapper{" +
                "index=" + index +
                ", task=" + task +
                ", numberOfParentTasks=" + numberOfParentTasks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskWrapper that = (TaskWrapper) o;
        return index == that.index && numberOfParentTasks == that.numberOfParentTasks && Objects.equals(task, that.task);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, task, numberOfParentTasks);
    }
}
