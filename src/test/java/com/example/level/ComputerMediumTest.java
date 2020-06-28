package com.example.level;

import com.example.game.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ComputerMediumTest {

    private ComputerMedium computerMedium;
    private Game game;
    private Random random;

    @BeforeEach
    void setUp() {
        game = Mockito.mock(Game.class);
        random = Mockito.mock(Random.class);
        computerMedium = new ComputerMedium(random, game);
    }

    @Test
    void chooseCoordinateCanWin() {
        String[] state = new String[]{"X", "1", "X", "3", "O", "O", "6", "7", "8"};
        when(game.getBoard()).thenReturn(state);
        when(game.getSize()).thenReturn(9);
        computerMedium.setMark("X");

        assertEquals("23", computerMedium.chooseCoordinate());
    }

    @Test
    void chooseCoordinateCanBlock() {
        String[] state = new String[]{"X", "1", "X", "3", "4", "O", "6", "7", "O"};
        when(game.getBoard()).thenReturn(state);
        when(game.getSize()).thenReturn(9);
        computerMedium.setMark("O");

        assertEquals("23", computerMedium.chooseCoordinate());
    }

    @Test
    void chooseCoordinateRandom() {
        String[] state = new String[]{"X", "O", "2", "3", "O", "5", "6", "X", "8"};
        when(game.getBoard()).thenReturn(state);
        when(game.getSize()).thenReturn(9);
        when(random.nextInt(3)).thenReturn(2);
        computerMedium.setMark("X");

        assertEquals("33", computerMedium.chooseCoordinate());
    }
}