package com.example.level;

public abstract class Player implements Level {

    private String coordinate;
    private String mark;

    @Override
    public String getCoordinate() {
        return coordinate;
    }

    @Override
    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public void setMark(String mark) {
        this.mark = mark;
    }

    @Override
    public String getMark() {
        return mark;
    }

     String convertToCoordinate(String position) {

        switch (position) {
            case "0":
                return "13";
            case "1":
                return "23";
            case "2":
                return "33";
            case "3":
                return "12";
            case "4":
                return "22";
            case "5":
                return "32";
            case "6":
                return "11";
            case "7":
                return "21";
            case "8":
                return "31";
            default:
                return null;
        }
    }
}
