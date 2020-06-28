package com.example.level;

import com.example.game.Game;
import com.example.util.Names;

import java.util.ArrayList;
import java.util.Objects;

public class ComputerHard extends Player {

    private Game game;
    private String opponent;

    public ComputerHard(Game game) {
        this.game = game;
    }

    @Override
    public String chooseCoordinate() {
        setOpponentMark();
        Move bestSpot = minMax(game.getBoard(), getMark());
        setCoordinate(convertToCoordinate(bestSpot.getIndex()));
        return getCoordinate();
    }

    private void setOpponentMark() {
        String opponent = Objects.equals(getMark(), Names.X_MARK) ? Names.O_MARK : Names.X_MARK;
        this.opponent = opponent;
    }

    private Move minMax(String[] newBoard, String player) {

        //find empty spots
        ArrayList<Integer> availSpots = findAvailableIndexes(newBoard);

        //check terminal state
        if (canWin(opponent)) {
            return new Move(-10);
        } else if (canWin(getMark())) {
            return new Move(10);
        } else if (availSpots.size() == 0) {
            return new Move(0);
        }

        //collection to collect all moves
        ArrayList<Move> moves = new ArrayList<>();
        for (int i = 0; i < availSpots.size(); i++) {
            Move move = new Move(newBoard[availSpots.get(i)]);

            //set an empty spot to the current player
            newBoard[availSpots.get(i)] = player;

            //collect the score resulted from calling minMax() on the opponent of the current player
            if (Objects.equals(player, getMark())) {
                Move result = minMax(newBoard, opponent);
                move.setScore(result.getScore());
            } else {
                Move result = minMax(newBoard, getMark());
                move.setScore(result.getScore());
            }

            //reset the spot to empty
            newBoard[availSpots.get(i)] = move.getIndex();
            //add move to the collection
            moves.add(move);
        }

        //if it is computers move, find first move with the highest score
        int bestMove = 0;
        if (Objects.equals(player, getMark())) {
            int bestScore = -20;
            for (int i = 0; i < moves.size(); i++) {
                if (moves.get(i).getScore() > bestScore) {
                    bestScore = moves.get(i).getScore();
                    bestMove = i;
                }
            }
        } else {//find first move with the lowest score
            int bestScore = 20;
            for (int i = 0; i < moves.size(); i++) {
                if (moves.get(i).getScore() < bestScore) {
                    bestScore = moves.get(i).getScore();
                    bestMove = i;
                }
            }
        }
        //return the chosen move to the higher depth
        return moves.get(bestMove);
    }

    private ArrayList<Integer> findAvailableIndexes(String[] board) {
        ArrayList<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            if (Objects.equals(board[i], getMark()) || Objects.equals(board[i], opponent)) {
                continue;
            } else {
                indexes.add(i);
            }
        }
        return indexes;
    }

    private boolean canWin(String mark) {
        if (checkMainDiagonal(mark)) {
            return true;
        } else if (checkCounterDiagonal(mark)) {
            return true;
        } else if (checkRows(mark)) {
            return true;
        } else {
            return checkColumns(mark);
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
