package org.example.application.cli;

import org.example.application.command.Command;

public interface Interpreter {
    Command readCommand(String[] arguments);
}
