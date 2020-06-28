package com.example.game;

import com.example.level.ComputerEasy;
import com.example.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class GameManagerTest {

    private Game game;
    private ResultChecker resultChecker;
    private GameManager gameManager;

    private Scanner scanner;
    private User user;
    private ComputerEasy computerEasy;

    private String[] O_Win = new String[]{"X", "O", "X", "3", "O", "5", "X", "O", "8"};

    @BeforeEach
    void setUp() {
        game = Mockito.mock(Game.class);
        resultChecker = Mockito.mock(ResultChecker.class);

        gameManager = new GameManager(game, resultChecker);
        gameManager.setMoveCounter(6);
    }

    @Test
    void getResult() {
        when(resultChecker.getResult(6)).thenReturn("O wins");
        assertEquals("O wins", gameManager.getResult());
    }

    @Test
    void resetGame() {
        gameManager.resetGame();
        assertEquals(0, gameManager.getMoveCounter());
    }

    @Test
    void usersMove() {
        scanner = Mockito.mock(Scanner.class);
        user = Mockito.mock(User.class);

        when(scanner.nextLine()).thenReturn("1 2");
        when(user.processCoordinates("1 2")).thenReturn(true);
        when(user.getCoordinate()).thenReturn("12");
        when(game.getBoard()).thenReturn(O_Win);

        String[] expected = new String[]{"X", "O", "X", "X", "O", "5", "X", "O", "8"};

        gameManager.usersMove(scanner, user, "X");

        assertArrayEquals(expected, game.getBoard());
    }

    @Test
    void computersMove() {
        computerEasy = Mockito.mock(ComputerEasy.class);

        when(computerEasy.chooseCoordinate()).thenReturn("12");
        when(computerEasy.getCoordinate()).thenReturn("12");
        when(game.getBoard()).thenReturn(O_Win);

        String[] expected = new String[]{"X", "O", "X", "O", "O", "5", "X", "O", "8"};

        gameManager.computersMove(computerEasy, "O", "easy");

        assertArrayEquals(expected, game.getBoard());
    }

    @Test
    void displayBoard() {
        when(game.getBoard()).thenReturn(O_Win);
        when(game.getSize()).thenReturn(9);

        String expected = "---------\n| X O X |\n|   O   |\n| X O   |\n---------";

        assertEquals(expected, gameManager.displayBoard());
    }
}