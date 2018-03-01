package com.company.Interfaces;

import com.company.Coordinate;

import java.util.List;

public interface ICar {
    List<IRide> getRides();
    void addRide(IRide ride); //rezultatai

    void setRide(IRide ride); //dabartinis
    int[] finish(); //kordinate paskutines stoteles


    int stepsLeft(int t);
    boolean isGoing(int t);
    boolean isFinished(int t);
}
