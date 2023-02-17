package org.example.infrastructure.command;

import org.example.application.command.Command;
import org.example.application.io.Printer;
import org.example.domain.model.Task;
import org.example.domain.model.TaskWrapper;
import org.example.domain.service.TaskService;
import org.example.infrastructure.serialization.TaskSerializer;

import java.util.ArrayList;
import java.util.List;

public class ListCommand implements Command {
    private int indexCounter = 0;

    @Override
    public void execute(TaskService taskService, Printer printer) {
        final List<Task> taskList = taskService.getAllTasks();
        this.indexCounter = 0;
        final List<TaskWrapper> taskWrapperList = flattenTaskList(taskList, 0);
        for (TaskWrapper taskWrapper : taskWrapperList) {
            printer.print(TaskSerializer.serialize(taskWrapper));
        }
    }

    private List<TaskWrapper> flattenTaskList(List<Task> taskList, int numberOfParentTasks) {
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
