package org.example.infrastructure.cli;

import org.example.application.cli.Interpreter;
import org.example.application.command.Command;
import org.example.infrastructure.command.ListCommand;
import org.example.infrastructure.command.RemoveCommand;

public class CommandLineInterpreter implements Interpreter {
    @Override
    public Command readCommand(String[] arguments) {
        if (arguments.length < 1) {
            throw new IllegalArgumentException("No command specified");
        } else if (arguments[0].equals("list")) {
            return new ListCommand();
        } else if (arguments[0].equals("remove")) {
            if (arguments.length < 2) {
                throw new IllegalArgumentException("No index specified");
            }
            int index = Integer.parseInt(arguments[1]);
            return new RemoveCommand(index);
        } else {
            throw new IllegalArgumentException("Unknown command: " + arguments[0]);
        }
    }
}
