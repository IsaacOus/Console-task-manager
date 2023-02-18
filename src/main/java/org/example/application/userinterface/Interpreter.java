package org.example.application.userinterface;

import org.example.application.command.Command;

public interface Interpreter {
    Command readCommand(String[] arguments);
}
