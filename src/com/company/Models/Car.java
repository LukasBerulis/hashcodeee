package com.company.Models;

import com.company.Interfaces.ICar;
import com.company.Interfaces.Ride;
import com.company.Main;

import java.util.ArrayList;
import java.util.List;

public class Car implements ICar {

    private List<Ride> rides;
    private Ride currentRide;
    public int index;
    int rideLength;
    int stepRideSet;
    int stepRideStarted;

    public Car(int i) {
        rides = new ArrayList<>();
        index = 0;
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
        stepRideSet = Main.currentStep;
        rideLength = Math.abs(currentRide.getX() - currentRide.getA())
                + Math.abs(currentRide.getY() - currentRide.getB());
        if (Main.currentStep >= ride.getS() + 1) stepRideStarted = Main.currentStep;
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
            int stepsElapsed = Main.currentStep - stepRideStarted;
            return rideLength - stepsElapsed;
        }
        return -1;
    }

    @Override
    public boolean isGoing(int t) {
        if (stepRideStarted > 0) {
            int stepsElapsed = Main.currentStep - stepRideStarted;
            return stepsElapsed < rideLength;
        }
        return true;
    }

    @Override
    public boolean isFinished() {
        if (currentRide == null) return true;
        if (stepRideStarted > 0) {
            int stepsElapsed = Main.currentStep - stepRideStarted;
            return stepsElapsed >= rideLength;
        }
        return false;
    }
}
