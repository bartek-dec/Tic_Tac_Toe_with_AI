package com.example.game;

import com.example.level.Level;
import com.example.user.User;
import com.example.util.Names;

import java.util.Objects;
import java.util.Scanner;

public class GameManager {

    private Game game;
    private ResultChecker resultChecker;
    private String coordinate;
    private int moveCounter;

    public GameManager(Game game, ResultChecker resultChecker) {
        this.game = game;
        this.resultChecker = resultChecker;
        this.moveCounter = 0;
    }

    public String getResult() {
        return resultChecker.getResult(moveCounter);
    }

    int getMoveCounter() {
        return moveCounter;
    }

    void setMoveCounter(int moveCounter) {
        this.moveCounter = moveCounter;
    }

    public void resetGame() {
        moveCounter = 0;
        game.resetBoard();
    }

    public void computersMove(Level computer, String mark, String levelName) {
        do {
            if (checkBoard(computer.chooseCoordinate())) {
                System.out.println(Names.MAKING_MOVE + levelName);
                setCoordinate(computer.getCoordinate());
                play(mark);
                System.out.println(displayBoard());
                return;
            }
        } while (true);
    }

    public void usersMove(Scanner scanner, User user, String mark) {
        do {
            System.out.print(Names.ENTER_COORDINATES);
            String userInput = scanner.nextLine();
            if (user.processCoordinates(userInput)) {
                if (checkBoard(user.getCoordinate())) {
                    setCoordinate(user.getCoordinate());
                    play(mark);
                    System.out.println(displayBoard());
                    return;
                } else {
                    System.out.println(Names.CELL_OCCUPIED);
                }
            }
        } while (true);
    }

    public String displayBoard() {
        StringBuilder builder = new StringBuilder();

        builder.append(Names.HORIZONTAL_BARS).append("\n");
        for (int i = 0; i < game.getSize(); i += 3) {
            builder.append(Names.VERTICAL_BAR).append(Names.EMPTY);

            if (Objects.equals(game.getBoard()[i], Names.X_MARK)
                    || Objects.equals(game.getBoard()[i], Names.O_MARK)) {
                builder.append(game.getBoard()[i] + Names.EMPTY);
            } else {
                builder.append(Names.EMPTY).append(Names.EMPTY);
            }

            if (Objects.equals(game.getBoard()[i + 1], Names.X_MARK)
                    || Objects.equals(game.getBoard()[i + 1], Names.O_MARK)) {
                builder.append(game.getBoard()[i + 1] + Names.EMPTY);
            } else {
                builder.append(Names.EMPTY).append(Names.EMPTY);
            }

            if (Objects.equals(game.getBoard()[i + 2], Names.X_MARK)
                    || Objects.equals(game.getBoard()[i + 2], Names.O_MARK)) {
                builder.append(game.getBoard()[i + 2] + Names.EMPTY);
            } else {
                builder.append(Names.EMPTY).append(Names.EMPTY);
            }

            builder.append(Names.VERTICAL_BAR).append("\n");
        }
        builder.append(Names.HORIZONTAL_BARS);
        return builder.toString();
    }

    private void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    private void play(String mark) {
        makeMove(mark);
        moveCounter++;
    }

    private boolean checkBoard(String coordinate) {
        switch (coordinate) {
            case "13":
                return !Objects.equals(game.getBoard()[0], Names.X_MARK) &&
                        !Objects.equals(game.getBoard()[0], Names.O_MARK);
            case "23":
                return !Objects.equals(game.getBoard()[1], Names.X_MARK) &&
                        !Objects.equals(game.getBoard()[1], Names.O_MARK);
            case "33":
                return !Objects.equals(game.getBoard()[2], Names.X_MARK) &&
                        !Objects.equals(game.getBoard()[2], Names.O_MARK);
            case "12":
                return !Objects.equals(game.getBoard()[3], Names.X_MARK) &&
                        !Objects.equals(game.getBoard()[3], Names.O_MARK);
            case "22":
                return !Objects.equals(game.getBoard()[4], Names.X_MARK) &&
                        !Objects.equals(game.getBoard()[4], Names.O_MARK);
            case "32":
                return !Objects.equals(game.getBoard()[5], Names.X_MARK) &&
                        !Objects.equals(game.getBoard()[5], Names.O_MARK);
            case "11":
                return !Objects.equals(game.getBoard()[6], Names.X_MARK) &&
                        !Objects.equals(game.getBoard()[6], Names.O_MARK);
            case "21":
                return !Objects.equals(game.getBoard()[7], Names.X_MARK) &&
                        !Objects.equals(game.getBoard()[7], Names.O_MARK);
            case "31":
                return !Objects.equals(game.getBoard()[8], Names.X_MARK) &&
                        !Objects.equals(game.getBoard()[8], Names.O_MARK);
            default:
                return false;
        }
    }


    private void makeMove(String mark) {
        switch (coordinate) {
            case "13":
                game.getBoard()[0] = mark;
                break;
            case "23":
                game.getBoard()[1] = mark;
                break;
            case "33":
                game.getBoard()[2] = mark;
                break;
            case "12":
                game.getBoard()[3] = mark;
                break;
            case "22":
                game.getBoard()[4] = mark;
                break;
            case "32":
                game.getBoard()[5] = mark;
                break;
            case "11":
                game.getBoard()[6] = mark;
                break;
            case "21":
                game.getBoard()[7] = mark;
                break;
            case "31":
                game.getBoard()[8] = mark;
                break;
        }
    }
}
