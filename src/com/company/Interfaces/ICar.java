package com.company.Interfaces;

import com.company.Coordinate;

import java.util.List;

public interface ICar {
    List<Ride> getRides();
    void addRide(Ride ride); //rezultatai

    void setRide(Ride ride); //dabartinis
    Ride getRide();
    int[] finish(); //kordinate paskutines stoteles

    int stepsLeft(int t);
    boolean isGoing(int t);
    boolean isFinished();
}
