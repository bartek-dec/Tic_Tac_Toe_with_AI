package com.example.level;

import com.example.game.Game;
import com.example.util.Names;

import java.util.Objects;
import java.util.Random;

public class ComputerMedium extends Player {

    private Random random;
    private Game game;
    private StringBuilder builder;

    public ComputerMedium(Random random, Game game) {
        this.random = random;
        this.game = game;
        this.builder = new StringBuilder();
    }

    @Override
    public String chooseCoordinate() {

        if (canWin(getMark()) != null) {
            setCoordinate(canWin(getMark()));
            return canWin(getMark());
        } else if (canBlock(getMark()) != null) {
            setCoordinate(canBlock(getMark()));
            return canBlock(getMark());
        } else {
            builder.append(random.nextInt(3) + 1);
            builder.append(random.nextInt(3) + 1);

            String coordinate = builder.toString();
            builder.setLength(0);
            setCoordinate(coordinate);
            return coordinate;
        }
    }

    private String canWin(String mark) {
        return getCoordinate(mark);
    }

    private String canBlock(String mark) {
        String opponentMark = Objects.equals(mark, Names.X_MARK) ? Names.O_MARK : Names.X_MARK;

        return getCoordinate(opponentMark);
    }

    private String getCoordinate(String mark) {
        if (checkMainDiagonal(mark) != null) {
            return convertToCoordinate(checkMainDiagonal(mark));
        } else if (checkCounterDiagonal(mark) != null) {
            return convertToCoordinate(checkCounterDiagonal(mark));
        } else if (checkRows(mark) != null) {
            return convertToCoordinate(checkRows(mark));
        } else if (checkColumns(mark) != null) {
            return convertToCoordinate(checkColumns(mark));
        }
        return null;
    }

    private String checkMainDiagonal(String s) {
        int marks = 0;
        int empty = 0;
        int iXPosition = 0;

        if (Objects.equals(game.getBoard()[0], s)) {
            marks++;
        } else if (Objects.equals(game.getBoard()[0], Names.EMPTY)) {
            empty++;
            iXPosition = 0;
        }

        if (Objects.equals(game.getBoard()[4], s)) {
            marks++;
        } else if (Objects.equals(game.getBoard()[4], Names.EMPTY)) {
            empty++;
            iXPosition = 4;
        }

        if (Objects.equals(game.getBoard()[8], s)) {
            marks++;
        } else if (Objects.equals(game.getBoard()[8], Names.EMPTY)) {
            empty++;
            iXPosition = 8;
        }


        if (marks == 2 && empty == 1) {
            return Integer.toString(iXPosition);
        }
        return null;
    }

    private String checkCounterDiagonal(String s) {
        String opponent = Objects.equals(s, Names.X_MARK) ? Names.O_MARK : Names.X_MARK;
        int marks = 0;
        int empty = 0;
        int iXPosition = 0;

        if (Objects.equals(game.getBoard()[2], s)) {
            marks++;
        } else if (!Objects.equals(game.getBoard()[2], opponent)) {
            empty++;
            iXPosition = 2;
        }

        if (Objects.equals(game.getBoard()[4], s)) {
            marks++;
        } else if (!Objects.equals(game.getBoard()[4], opponent)) {
            empty++;
            iXPosition = 4;
        }

        if (Objects.equals(game.getBoard()[6], s)) {
            marks++;
        } else if (!Objects.equals(game.getBoard()[6], opponent)) {
            empty++;
            iXPosition = 6;
        }

        if (marks == 2 && empty == 1) {
            return Integer.toString(iXPosition);
        }
        return null;
    }

    private String checkRows(String s) {
        String opponent = Objects.equals(s, Names.X_MARK) ? Names.O_MARK : Names.X_MARK;
        int marks = 0;
        int empty = 0;
        int iXPosition = 0;

        for (int i = 0; i < game.getSize(); i += 3) {
            if (Objects.equals(game.getBoard()[i], s)) {
                marks++;
            } else if (!Objects.equals(game.getBoard()[i], opponent)) {
                empty++;
                iXPosition = i;
            }

            if (Objects.equals(game.getBoard()[i + 1], s)) {
                marks++;
            } else if (!Objects.equals(game.getBoard()[i + 1], opponent)) {
                empty++;
                iXPosition = i + 1;
            }

            if (Objects.equals(game.getBoard()[i + 2], s)) {
                marks++;
            } else if (!Objects.equals(game.getBoard()[i + 2], opponent)) {
                empty++;
                iXPosition = i + 2;
            }

            if (marks == 2 && empty == 1) {
                return Integer.toString(iXPosition);
            } else {
                marks = 0;
                empty = 0;
                iXPosition = 0;
            }
        }
        return null;
    }

    private String checkColumns(String s) {
        String opponent = Objects.equals(s, Names.X_MARK) ? Names.O_MARK : Names.X_MARK;
        int marks = 0;
        int empty = 0;
        int iXPosition = 0;

        for (int i = 0; i < 3; i++) {
            if (Objects.equals(game.getBoard()[i], s)) {
                marks++;
            } else if (!Objects.equals(game.getBoard()[i], opponent)) {
                empty++;
                iXPosition = i;
            }

            if (Objects.equals(game.getBoard()[i + 3], s)) {
                marks++;
            } else if (!Objects.equals(game.getBoard()[i + 3], opponent)) {
                empty++;
                iXPosition = i + 3;
            }

            if (Objects.equals(game.getBoard()[i + 6], s)) {
                marks++;
            } else if (!Objects.equals(game.getBoard()[i + 6], opponent)) {
                empty++;
                iXPosition = i + 6;
            }

            if (marks == 2 && empty == 1) {
                return Integer.toString(iXPosition);
            } else {
                marks = 0;
                empty = 0;
                iXPosition = 0;
            }
        }
        return null;
    }
}
