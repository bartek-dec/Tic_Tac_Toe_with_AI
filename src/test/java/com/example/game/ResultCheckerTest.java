package com.example.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ResultCheckerTest {

    private ResultChecker resultChecker;
    private Game game;

    private String[] draw = new String[]{"X", "O", "X", "X", "O", "O", "O", "X", "X"};
    private String[] X_Win = new String[]{"X", "O", "2", "3", "X", "O", "6", "7", "X"};
    private String[] O_Win = new String[]{"X", "O", "X", "3", "O", "5", "X", "O", "8"};

    @BeforeEach
    void setUp() {
        game = Mockito.mock(Game.class);
        resultChecker = new ResultChecker(game);
    }

    @Test
    void getResultDraw() {
        when(game.getBoard()).thenReturn(draw);

        assertEquals("Draw", resultChecker.getResult(9));
    }

    @Test
    void getResultXWin() {
        when(game.getBoard()).thenReturn(X_Win);

        assertEquals("X wins", resultChecker.getResult(5));
    }

    @Test
    void getResultOWins() {
        when(game.getBoard()).thenReturn(O_Win);

        assertEquals("O wins", resultChecker.getResult(6));
    }
}