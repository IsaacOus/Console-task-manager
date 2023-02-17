package org.example;

import org.example.application.cli.Interpreter;
import org.example.application.command.Command;
import org.example.infrastructure.cli.CommandLineInterpreter;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Interpreter interpreter = new CommandLineInterpreter();
        Command command = interpreter.readCommand(args);

    }
}
