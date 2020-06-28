package com.example.level;

import java.util.Random;

public class ComputerEasy extends Player {

    private Random random;

    public ComputerEasy(Random random) {
        this.random = random;
    }

    @Override
    public String chooseCoordinate() {
        StringBuilder builder = new StringBuilder();
        builder.append(random.nextInt(3) + 1);
        builder.append(random.nextInt(3) + 1);

        setCoordinate(builder.toString());
        return builder.toString();
    }
}
