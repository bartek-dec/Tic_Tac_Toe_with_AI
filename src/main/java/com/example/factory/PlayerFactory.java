package com.example.factory;

import com.example.game.Game;
import com.example.level.ComputerEasy;
import com.example.level.ComputerHard;
import com.example.level.ComputerMedium;
import com.example.level.Level;
import com.example.util.Names;

import java.util.Objects;
import java.util.Random;

public class PlayerFactory extends Factory {

    private Random random;
    private Game game;

    public PlayerFactory(Random random, Game game) {
        this.random = random;
        this.game = game;
    }

    @Override
    Level createPlayer(String type) {
        if (Objects.equals(type, Names.EASY)) {
            return new ComputerEasy(random);
        } else if (Objects.equals(type, Names.MEDIUM)) {
            return new ComputerMedium(random, game);
        } else if (Objects.equals(type, Names.HARD)) {
            return new ComputerHard(game);
        }

        return null;
    }
}
