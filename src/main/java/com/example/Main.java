package com.example;

import com.example.factory.PlayerFactory;
import com.example.game.Game;
import com.example.game.GameManager;
import com.example.game.ResultChecker;
import com.example.level.Level;
import com.example.manager.CommandManager;
import com.example.user.User;
import com.example.util.Names;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        CommandManager commandManager = new CommandManager();
        Game game = new Game();
        ResultChecker resultChecker = new ResultChecker(game);
        GameManager gameManager = new GameManager(game, resultChecker);
        PlayerFactory playerFactory = new PlayerFactory(random, game);


        String[] commands = commandManager.getCommand(scanner);
        while (!commands[0].equals(Names.EXIT)) {

            System.out.println(gameManager.displayBoard());

            boolean gameFlag = true;
            do {

                setPlayers(scanner, gameManager, playerFactory, commands, 1, Names.X_MARK);

                if (gameManager.getResult() == null) {

                    setPlayers(scanner, gameManager, playerFactory, commands, 2, Names.O_MARK);

                } else {
                    gameFlag = false;
                }

                if (gameManager.getResult() != null) {
                    gameFlag = false;
                }
            } while (gameFlag);

            System.out.println(gameManager.getResult());
            gameManager.resetGame();
            commands = commandManager.getCommand(scanner);
        }
    }

    private static void setPlayers(Scanner scanner, GameManager gameManager, PlayerFactory playerFactory,
                                   String[] commands, int i, String mark) {
        if (Objects.equals(commands[i], Names.USER)) {

            User user = new User();
            gameManager.usersMove(scanner, user, mark);

        } else {

            Level computer = playerFactory.getPlayer(commands[i]);
            computer.setMark(mark);
            gameManager.computersMove(computer, mark, commands[i]);

        }
    }
}
