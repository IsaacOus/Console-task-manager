package org.example.infrastructure.serialization;

import org.example.domain.model.Task;
import org.example.domain.model.TaskWrapper;

import java.util.ArrayList;
import java.util.List;

public class TaskSerializer {
    private static int indexCounter = 0;

    public static String serializeToString(TaskWrapper task) {
        StringBuilder serializedTask = new StringBuilder();

        // set color based on task state
        String stateColor = "";
        switch (task.getTask().getState()) {
            case TODO:
                stateColor = "\u001B[31m"; // red
                break;
            case PROGRESS:
                stateColor = "\u001B[33m"; // yellow
                break;
            case DONE:
                stateColor = "\u001B[32m"; // green
                break;
            case CANCELLED:
                stateColor = "\u001B[35m"; // magenta
                break;
            case CLOSED:
                stateColor = "\u001B[36m"; // cyan
                break;
            case PENDING:
                stateColor = "\u001B[37m"; // white
                break;
            default:
                break;
        }

        serializedTask.append(repeatChar("\t", task.getNumberOfParentTasks())).append("Task #").append(task.getIndex()).append("\n");
        serializedTask.append(repeatChar("\t", task.getNumberOfParentTasks())).append(stateColor).append("[").append(task.getTask().getState().getName()).append("] - \"").append(task.getTask().getDescription()).append("\"").append("\u001B[0m").append("\n");
        serializedTask.append(repeatChar("\t", task.getNumberOfParentTasks())).append("#").append(task.getTask().getTag()).append("\n");
        serializedTask.append(repeatChar("\t", task.getNumberOfParentTasks())).append("[Created: ").append(task.getTask().getCreationDate()).append("][Due: ").append(task.getTask().getDueDate()).append("][Closed: ").append(task.getTask().getCloseDate()).append("]\n");
        serializedTask.append(repeatChar("\t", task.getNumberOfParentTasks())).append("SubTasks:\n");
        if (task.getTask().getSubTasks() == null || task.getTask().getSubTasks().isEmpty()) {
            serializedTask.append(repeatChar("\t", task.getNumberOfParentTasks())).append("\tNone\n");
        }
        return serializedTask.toString();
    }


    private static String repeatChar(String s, int n) {
        return String.valueOf(s).repeat(n);
    }

    public static List<TaskWrapper> serializeToTaskWrapperList(List<Task> taskList) {
        indexCounter = 0;
        return flattenTaskList(taskList, 0);
    }

    private static List<TaskWrapper> flattenTaskList(List<Task> taskList, int numberOfParentTasks) {
        final List<TaskWrapper> taskWrapperList = new ArrayList<>();
        for (final Task task : taskList) {
            indexCounter++;
            taskWrapperList.add(new TaskWrapper(indexCounter, task, numberOfParentTasks));
            if (task.getSubTasks() != null && !task.getSubTasks().isEmpty()) {
                taskWrapperList.addAll(flattenTaskList(task.getSubTasks(), numberOfParentTasks + 1));
            }
        }
        return taskWrapperList;
    }
}
