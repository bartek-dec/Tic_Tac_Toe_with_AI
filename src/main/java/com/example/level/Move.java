package com.example.level;

public class Move {

    private String index;
    private int score;

    public Move(int score) {
        this.score = score;
    }

    public Move(String index) {
        this.index = index;
    }

    public String getIndex() {
        return index;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
