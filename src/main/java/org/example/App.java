package org.example;

import org.example.application.cli.Interpreter;
import org.example.application.command.Command;
import org.example.application.io.Printer;
import org.example.domain.repository.TaskRepository;
import org.example.domain.service.TaskService;
import org.example.infrastructure.cli.CommandLineInterpreter;
import org.example.infrastructure.io.CommandLinePrinter;
import org.example.infrastructure.repository.LocalTaskRepositoryImpl;
import org.example.infrastructure.service.TaskServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        TaskRepository taskRepository = new LocalTaskRepositoryImpl();
        TaskService taskService = new TaskServiceImpl(taskRepository);
        Printer printer = new CommandLinePrinter();
        Interpreter interpreter = new CommandLineInterpreter();
        Command command = interpreter.readCommand(args);
        command.execute(taskService, printer);
    }
}
