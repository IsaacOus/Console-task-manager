package org.example.infrastructure.cli;


import org.example.application.command.Command;
import org.example.infrastructure.command.AddCommand;
import org.example.infrastructure.command.ListCommand;
import org.example.infrastructure.command.RemoveCommand;
import org.example.infrastructure.command.UpdateCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CommandLineInterpreterTest {

    private final CommandLineInterpreter cli = new CommandLineInterpreter();

    @Test
    void testReadCommandWithEmptyArguments() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> cli.readCommand(new String[]{}));
    }

    @Test
    void testReadCommandWithListCommand() {
        Command command = cli.readCommand(new String[]{"list"});
        Assertions.assertTrue(command instanceof ListCommand);
    }

    @Test
    void testReadCommandWithRemoveCommand() {
        Command command = cli.readCommand(new String[]{"remove", "1"});
        Assertions.assertTrue(command instanceof RemoveCommand);
    }

    @Test
    void testReadCommandWithAddCommand() {
        Command command = cli.readCommand(new String[]{"add", "-c", "content", "-d:2023-02-20", "-s", "done"});
        Assertions.assertTrue(command instanceof AddCommand);
    }

    @Test
    void testReadCommandWithUpdateCommand() {
        Command command = cli.readCommand(new String[]{"update", "1", "-c", "content", "-d:2023-02-20", "-s", "done"});
        Assertions.assertTrue(command instanceof UpdateCommand);
    }

    @Test
    void testReadCommandWithUnknownCommand() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> cli.readCommand(new String[]{"invalid"}));
    }

    @Test
    void testReadCommandWithMissingIndexForRemoveCommand() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> cli.readCommand(new String[]{"remove"}));
    }

    @Test
    void testReadCommandWithMissingDataForAddCommand() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> cli.readCommand(new String[]{"add"}));
    }

    @Test
    void testReadCommandWithMissingIndexForUpdateCommand() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> cli.readCommand(new String[]{"update"}));
    }

    @Test
    void testUpdateCommandWithNoEnoughtArguments() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> cli.readCommand(new String[]{"update", "1"}));
    }

}

