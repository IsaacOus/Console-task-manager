package org.example.infrastructure.command;

import org.example.application.command.Command;
import org.example.application.io.Printer;
import org.example.domain.model.Task;
import org.example.domain.model.TaskWrapper;
import org.example.domain.service.TaskService;
import org.example.infrastructure.serialization.TaskSerializer;

import java.util.List;

public class ListCommand implements Command {
    @Override
    public void execute(TaskService taskService, Printer printer) {
        final List<Task> taskList = taskService.getAllTasks();
        final List<TaskWrapper> taskWrapperList = TaskSerializer.serializeToTaskWrapperList(taskList);
        for (TaskWrapper taskWrapper : taskWrapperList) {
            printer.print(TaskSerializer.serializeToString(taskWrapper));
        }
    }
}
