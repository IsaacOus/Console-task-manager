package org.example.infrastructure.serialization;

import org.example.domain.model.TaskWrapper;

public class TaskSerializer {
    public static String serialize(TaskWrapper task) {
        StringBuilder serializedTask = new StringBuilder();
        serializedTask.append(TaskSerializer.repeatChar("\t", task.getNumberOfParentTasks())).append("Task #").append(task.getIndex()).append("\n");
        serializedTask.append(TaskSerializer.repeatChar("\t", task.getNumberOfParentTasks())).append("[").append(task.getTask().getState()).append("] - \"").append(task.getTask().getDescription()).append("\"\n");
        serializedTask.append(TaskSerializer.repeatChar("\t", task.getNumberOfParentTasks())).append("#").append(task.getTask().getTag()).append("\n");
        serializedTask.append(TaskSerializer.repeatChar("\t", task.getNumberOfParentTasks())).append("[Created: ").append(task.getTask().getCreationDate()).append("][Due: ").append(task.getTask().getDueDate()).append("][Closed: ").append(task.getTask().getCloseDate()).append("]\n");
        serializedTask.append(TaskSerializer.repeatChar("\t", task.getNumberOfParentTasks())).append("SubTasks:\n");
        if (task.getTask().getSubTasks() == null || task.getTask().getSubTasks().isEmpty()) {
            serializedTask.append(TaskSerializer.repeatChar("\t", task.getNumberOfParentTasks())).append("\tNone\n");
        }
        return serializedTask.toString();
    }

    public static String repeatChar(String s, int n) {
        return String.valueOf(s).repeat(n);
    }

}
