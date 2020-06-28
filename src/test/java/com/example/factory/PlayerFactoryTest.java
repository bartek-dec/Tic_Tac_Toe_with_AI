package com.example.factory;

import com.example.game.Game;
import com.example.level.ComputerEasy;
import com.example.level.ComputerHard;
import com.example.level.ComputerMedium;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class PlayerFactoryTest {

    private PlayerFactory playerFactory;
    private Random random;
    private Game game;

    @BeforeEach
    void setUp() {
        random = Mockito.mock(Random.class);
        game = Mockito.mock(Game.class);
        playerFactory = new PlayerFactory(random, game);
    }

    @Test
    void getPlayerWhenEasyParameterThanComputerEasyObj() {
        assertTrue(playerFactory.getPlayer("easy") instanceof ComputerEasy);
    }

    @Test
    void getPlayerWhenMediumParameterThanComputerMediumObj() {
        assertTrue(playerFactory.getPlayer("medium") instanceof ComputerMedium);
    }

    @Test
    void getPlayerWhenMediumParameterThanComputerHardObj() {
        assertTrue(playerFactory.getPlayer("hard") instanceof ComputerHard);
    }
}