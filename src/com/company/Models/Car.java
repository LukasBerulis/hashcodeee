package com.company.Models;

import com.company.Interfaces.ICar;
import com.company.Interfaces.Ride;

import java.util.ArrayList;
import java.util.List;

public class Car implements ICar {

    private List<Ride> rides;
    private Ride currentRide;
    public int index;
    private int step;
    int rideLength;
    int stepRideSet;
    int stepRideStarted;

    public Car(int i) {
        rides = new ArrayList<>();
        step = 0;
        index = 0;
    }

    @Override
    public List<Ride> getRides() {
        return rides;
    }

    public void step() {
        step++;
    }

    @Override
    public void addRide(Ride ride) {
        rides.add(ride);
    }

    @Override
    public void setRide(Ride ride) {
        currentRide = ride;
        stepRideSet = step;
        rideLength = Math.abs(currentRide.getX() - currentRide.getA())
                + Math.abs(currentRide.getY() - currentRide.getB());
        if (step >= ride.getS() + 1) stepRideStarted = step;
    }

    @Override
    public Ride getRide() {
        return currentRide;
    }

    @Override
    public int[] finish() {
        if (currentRide != null)
            return new int[]{
                    currentRide.getX(),
                    currentRide.getY()
            };
        return new int[]{
                0,
                0
        };
    }

    @Override
    public int stepsLeft(int t) {
        if (stepRideStarted > 0) {
            int stepsElapsed = step - stepRideStarted;
            return rideLength - stepsElapsed;
        }
        return -1;
    }

    @Override
    public boolean isGoing(int t) {
        if (stepRideStarted > 0) {
            int stepsElapsed = step - stepRideStarted;
            return stepsElapsed < rideLength;
        }
        return true;
    }

    @Override
    public boolean isFinished() {
        if (currentRide == null) return true;
        if (stepRideStarted > 0) {
            int stepsElapsed = step - stepRideStarted;
            return stepsElapsed >= rideLength;
        }
        return false;
    }
}
