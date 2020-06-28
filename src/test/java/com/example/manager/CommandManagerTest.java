package com.example.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.when;

class CommandManagerTest {

    private CommandManager commandManager;
    private Scanner scanner;

    @BeforeEach
    void setUp() {
        commandManager = new CommandManager();
        scanner = Mockito.mock(Scanner.class);
    }

    @Test
    void getCommandWhenExitThanThisCommand() {
        when(scanner.nextLine()).thenReturn("exit");
        String[] expected = new String[]{"exit"};

        assertArrayEquals(expected, commandManager.getCommand(scanner));
    }

    @Test
    void getCommandWhenThreeCommandsThanArrayWithThoseCommands() {
        when(scanner.nextLine()).thenReturn("start user user");
        String[] expected = new String[]{"start", "user", "user"};

        assertArrayEquals(expected, commandManager.getCommand(scanner));
    }
}