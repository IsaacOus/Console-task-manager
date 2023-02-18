package org.example.infrastructure.cli;

import org.example.application.cli.Interpreter;
import org.example.application.command.Command;
import org.example.infrastructure.command.AddCommand;
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
        } else if (arguments[0].equals("add")) {
            if (arguments.length < 2) {
                throw new IllegalArgumentException("No data specified");
            }
            String content = "";
            String dueDate = "";
            String status = "";
            for (int i = 1; i < arguments.length; i++) {
                if (arguments[i].startsWith("-c")) {
                    content = arguments[i + 1];
                    i++;
                } else if (arguments[i].startsWith("-d:")) {
                    dueDate = arguments[i].substring(3);
                } else if (arguments[i].startsWith("-s")) {
                    status = arguments[i + 1];
                    i++;
                }
            }
            return new AddCommand(content, dueDate, status);
        }
        else {
            throw new IllegalArgumentException("Unknown command: " + arguments[0]);
        }
    }
}
