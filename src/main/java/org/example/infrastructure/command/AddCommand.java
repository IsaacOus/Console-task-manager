package org.example.infrastructure.command;

import org.example.application.command.Command;
import org.example.application.io.Printer;
import org.example.domain.service.TaskService;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class AddCommand implements Command {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final String content;
    private final String dueDate;
    private final String status;

    public AddCommand(String content, String dueDate, String status) {
        this.content = content;
        this.dueDate = dueDate;
        this.status = status;
    }

    @Override
    public void execute(TaskService taskService, Printer printer) {
        OffsetDateTime creationDate = OffsetDateTime.now();
        OffsetDateTime dueDate = null;
        OffsetDateTime closeDate = null;
        String tag = null;
        if (!this.dueDate.isBlank()) {
            dueDate = OffsetDateTime.of(LocalDate.parse(this.dueDate, this.formatter).atStartOfDay(), ZoneOffset.UTC);
        }
        if (status.equals("done")) {
            closeDate = OffsetDateTime.now();
        }
        taskService.addTask(content, creationDate, dueDate, closeDate, tag, null);
        printer.print("Task added");
    }
}
