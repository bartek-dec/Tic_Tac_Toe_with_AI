package com.example.game;

import com.example.util.Names;

import java.util.Objects;

public class ResultChecker {

    private Result xWins = Result.X_WINS;
    private Result oWins = Result.O_WINS;
    private Result draw = Result.DRAW;

    private Game game;
    private String result;

    public ResultChecker(Game game) {
        this.game = game;
    }

    public String getResult(int moveCounter) {
        setResult(moveCounter);
        return result;
    }

    private void setResult(int moveCounter) {
        if (isDiagonal() > 0) {
            if (isDiagonal() == 1) {
                this.result = xWins.getResult();
            } else if (isDiagonal() == 2) {
                this.result = xWins.getResult();
            } else if (isDiagonal() == 3) {
                this.result = oWins.getResult();
            } else if (isDiagonal() == 4) {
                this.result = oWins.getResult();
            }
        } else if (isRow()) {
            if (checkRows(Names.X_MARK)) {
                this.result = xWins.getResult();
            } else if (checkRows(Names.O_MARK)) {
                this.result = oWins.getResult();
            }
        } else if (isColumn()) {
            if (checkColumns(Names.X_MARK)) {
                this.result = xWins.getResult();
            } else if (checkColumns(Names.O_MARK)) {
                this.result = oWins.getResult();
            }
        } else if (moveCounter == 9) {
            this.result = draw.getResult();
        } else {
            this.result = null;
        }
    }

    private int isDiagonal() {
        if (checkMainDiagonal(Names.X_MARK)) {
            return 1;
        } else if (checkCounterDiagonal(Names.X_MARK)) {
            return 2;
        } else if (checkMainDiagonal(Names.O_MARK)) {
            return 3;
        } else if (checkCounterDiagonal(Names.O_MARK)) {
            return 4;
        } else {
            return -1;
        }
    }

    private boolean checkMainDiagonal(String s) {
        return Objects.equals(game.getBoard()[0], s) &&
                Objects.equals(game.getBoard()[4], s) &&
                Objects.equals(game.getBoard()[8], s);
    }

    private boolean checkCounterDiagonal(String s) {
        return Objects.equals(game.getBoard()[2], s) &&
                Objects.equals(game.getBoard()[4], s) &&
                Objects.equals(game.getBoard()[6], s);
    }

    private boolean isRow() {
        if (checkRows(Names.X_MARK)) {
            return true;
        } else {
            return checkRows(Names.O_MARK);
        }
    }

    private boolean checkRows(String s) {
        if (Objects.equals(game.getBoard()[0], s) &&
                Objects.equals(game.getBoard()[1], s) &&
                Objects.equals(game.getBoard()[2], s)) {
            return true;
        } else if (Objects.equals(game.getBoard()[3], s) &&
                Objects.equals(game.getBoard()[4], s) &&
                Objects.equals(game.getBoard()[5], s)) {
            return true;
        } else if (Objects.equals(game.getBoard()[6], s) &&
                Objects.equals(game.getBoard()[7], s) &&
                Objects.equals(game.getBoard()[8], s)) {
            return true;
        }
        return false;
    }

    private boolean isColumn() {
        if (checkColumns(Names.X_MARK)) {
            return true;
        } else {
            return checkColumns(Names.O_MARK);
        }
    }

    private boolean checkColumns(String s) {
        if (Objects.equals(game.getBoard()[0], s) &&
                Objects.equals(game.getBoard()[3], s) &&
                Objects.equals(game.getBoard()[6], s)) {
            return true;
        } else if (Objects.equals(game.getBoard()[1], s) &&
                Objects.equals(game.getBoard()[4], s) &&
                Objects.equals(game.getBoard()[7], s)) {
            return true;
        } else if (Objects.equals(game.getBoard()[2], s) &&
                Objects.equals(game.getBoard()[5], s) &&
                Objects.equals(game.getBoard()[8], s)) {
            return true;
        }
        return false;
    }
}
