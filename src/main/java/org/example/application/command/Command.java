package org.example.application.command;

import org.example.application.io.Printer;
import org.example.domain.service.TaskService;

public interface Command {
    void execute(TaskService taskService, Printer printer);
}
