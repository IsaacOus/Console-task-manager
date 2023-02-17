package org.example.infrastructure.command;

import org.example.application.command.Command;
import org.example.application.io.Printer;
import org.example.domain.model.Task;
import org.example.domain.service.TaskService;

import java.util.List;

public class ListCommand implements Command {
    @Override
    public void execute(TaskService taskService, Printer printer) {
        List<Task> taskList = taskService.getAllTasks();
        printer.print(taskList.toString());
    }
}
