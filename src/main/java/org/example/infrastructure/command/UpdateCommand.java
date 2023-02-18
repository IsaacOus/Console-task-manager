package org.example.infrastructure.command;

import org.example.application.command.Command;
import org.example.application.io.Printer;
import org.example.domain.service.TaskService;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class UpdateCommand implements Command {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final int index;
    private final String content;
    private final String dueDate;
    private final String status;

    public UpdateCommand(int index, String content, String dueDate, String status) {
        this.index = index;
        this.content = content;
        this.dueDate = dueDate;
        this.status = status;
    }

    @Override
    public void execute(TaskService taskService, Printer printer) {
        OffsetDateTime dueDate = null;
        if (!this.dueDate.isBlank()) {
            dueDate = OffsetDateTime.of(LocalDate.parse(this.dueDate, this.formatter).atStartOfDay(), ZoneOffset.UTC);
        }
        final boolean result = taskService.updateTask(index - 1, content, dueDate, status);
        if (!result) {
            printer.print("Failed to update task");
        } else {
            printer.print("Task updated");
        }
    }
}
