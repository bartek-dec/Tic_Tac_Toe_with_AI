package com.example.level;

import com.example.game.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ComputerHardTest {

    private ComputerHard computerHard;
    private Game game;

    @BeforeEach
    void setUp() {
        game = Mockito.mock(Game.class);
        computerHard = new ComputerHard(game);
    }

    @Test
    void chooseCoordinateExpect22() {
        String[] state = new String[]{"O", "1", "X", "X", "4", "X", "6", "O", "O"};
        when(game.getBoard()).thenReturn(state);
        computerHard.setMark("X");

        assertEquals("22", computerHard.chooseCoordinate());
    }

    @Test
    void chooseCoordinateExpect33() {
        String[] state = new String[]{"X", "X", "2", "X", "O", "5", "O", "O", "8"};
        when(game.getBoard()).thenReturn(state);
        computerHard.setMark("O");

        assertEquals("33", computerHard.chooseCoordinate());
    }
}