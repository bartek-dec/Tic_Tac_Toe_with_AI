package com.example.level;

public interface Level {

    String getCoordinate();

    void setCoordinate(String coordinate);

    void setMark(String mark);

    String getMark();

    String chooseCoordinate();
}
