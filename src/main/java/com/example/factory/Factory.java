package com.example.factory;

import com.example.level.Level;

public abstract class Factory {

    abstract Level createPlayer(String type);

    public Level getPlayer(String type) {
        Level player = createPlayer(type);
        return player;
    }
}
