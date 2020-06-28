package com.example.user;

import com.example.level.Player;
import com.example.util.Names;

public class User extends Player {

    @Override
    public String chooseCoordinate() {
        return getCoordinate();
    }

    public boolean processCoordinates(String s) {
        String[] coordinates = s.split("\\s+");
        int x;
        int y;
        try {
            x = Integer.parseInt(coordinates[0]);
            y = Integer.parseInt(coordinates[1]);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println(Names.ENTER_NUMBERS);
            return false;
        }

        if (((x <= 0) || (x > 3)) || ((y <= 0) || (y > 3))) {
            System.out.println(Names.WRONG_COORDINATES);
            return false;
        } else {
            String coordinate = Integer.toString(x) + y;
            setCoordinate(coordinate);
            return true;
        }
    }
}
