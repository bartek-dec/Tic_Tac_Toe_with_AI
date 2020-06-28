package com.example.manager;

import com.example.util.Names;

import java.util.Objects;
import java.util.Scanner;

public class CommandManager {

    public String[] getCommand(Scanner scanner) {
        boolean flag = true;
        String[] commands;
        do {
            System.out.print(Names.INPUT);
            commands = scanner.nextLine().toLowerCase().split("\\s+");

            if (commands.length == 1) {
                if (!Objects.equals(commands[0], Names.EXIT)) {
                    System.out.println(Names.BAD_PARAM);
                    continue;
                }
            } else {
                try {
                    String command = commands[0];
                    String player1 = commands[1];
                    String player2 = commands[2];

                    if (!Objects.equals(command, Names.START)) {
                        System.out.println(Names.BAD_PARAM);
                        continue;
                    }

                    if ((!Objects.equals(player1, Names.USER)) &&
                            (!Objects.equals(player1, Names.EASY)) &&
                            (!Objects.equals(player1, Names.MEDIUM)) &&
                            (!Objects.equals(player1, Names.HARD))) {
                        System.out.println(Names.BAD_PARAM);
                        continue;
                    }

                    if ((!Objects.equals(player2, Names.USER)) &&
                            (!Objects.equals(player2, Names.EASY)) &&
                            (!Objects.equals(player2, Names.MEDIUM)) &&
                            (!Objects.equals(player2, Names.HARD))) {
                        System.out.println(Names.BAD_PARAM);
                        continue;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println(Names.BAD_PARAM);
                    continue;
                }
            }
            flag = false;
        } while (flag);
        return commands;
    }
}
