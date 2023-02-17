package org.example.infrastructure.command;

import org.example.application.command.Command;
import org.example.application.io.Printer;
import org.example.domain.service.TaskService;

public class RemoveCommand implements Command {
    private final int index;

    public RemoveCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskService taskService, Printer printer) {
        boolean isCommandSucceed = taskService.removeTask(index - 1);
        if (isCommandSucceed) {
            printer.print("Task #" + index + " removed");
        } else {
            printer.print("Failed to remove Task #" + index);
        }
    }
}
