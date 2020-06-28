package com.example.game;

public class Game {

    private final int size = 9;

    private String[] board;

    public Game() {
        this.board = new String[size];
        fillBoard();
    }

    public String[] getBoard() {
        return board;
    }

    void setBoard(String[] board) {
        this.board = board;
    }

    public int getSize() {
        return size;
    }

    public void resetBoard() {
        this.board = new String[size];
        fillBoard();
    }

    private void fillBoard() {
        for (int i = 0; i < size; i++) {
            board[i] = Integer.toString(i);
        }
    }
}
