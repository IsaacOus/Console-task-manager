package org.example.infrastructure.cli;

import org.example.application.cli.Interpreter;
import org.example.application.command.Command;
import org.example.infrastructure.command.ListCommand;

public class CommandLineInterpreter implements Interpreter {
    @Override
    public Command readCommand(String[] arguments) {
        if (arguments.length < 1) {
            throw new IllegalArgumentException("No command specified");
        } else if (arguments[0].equals("list")) {
            return new ListCommand();
        } else {
            throw new IllegalArgumentException("Unknown command: " + arguments[0]);
        }
    }
}
