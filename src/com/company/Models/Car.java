package com.company.Models;

import com.company.Interfaces.ICar;
import com.company.Interfaces.Ride;

import java.util.ArrayList;
import java.util.List;

public class Car implements ICar {

    private List<Ride> rides;
    private Ride currentRide;
    private int step;
    int rideLength;
    int stepRideSet;

    public Car() {
        rides = new ArrayList<>();
        step = 0;
    }

    @Override
    public List<Ride> getRides() {
        return rides;
    }

    @Override
    public void addRide(Ride ride) {
        rides.add(ride);
    }

    @Override
    public void setRide(Ride ride) {
        currentRide = ride;

    }

    @Override
    public Ride getRide() {
        return currentRide;
    }

    @Override
    public int[] finish() {
        return new int[2];
    }

    @Override
    public int stepsLeft(int t) {
        return 0;
    }

    @Override
    public boolean isGoing(int t) {
        return false;
    }

    @Override
    public boolean isFinished() {
        step++;

        return false;
    }
}
