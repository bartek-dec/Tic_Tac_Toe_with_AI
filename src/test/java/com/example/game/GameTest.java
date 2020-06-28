package com.example.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private Game game;
    private String[] draw = new String[]{"X", "O", "X", "X", "O", "O", "O", "X", "X"};

    @Test
    void resetBoard() {
        game = new Game();
        game.setBoard(draw);

        String[] expected = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8"};
        game.resetBoard();

        assertArrayEquals(expected, game.getBoard());
    }
}