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
    public boolean started = false;

    public Car(int i) {
        rides = new ArrayList<>();
        index = i;
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
        if (Main.currentStep >= ride.getS()) stepRideStarted = Main.currentStep;
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
       // System.out.println("zzzzzz");
        //System.out.println(currentRide.getS());
        //System.out.println(Main.currentStep);
        //System.out.println("zzzzz");
        if ((Main.currentStep >= currentRide.getS() ) && !started) {
            stepRideStarted = Main.currentStep;
            started = true;
        }
        if (stepRideStarted > 0) {
           // System.out.println("xxxxxx");
           // System.out.println(Main.currentStep - stepRideStarted);
           // System.out.println(Main.currentStep);
            //System.out.println("xxxxxx");
            int stepsElapsed = Main.currentStep - stepRideStarted;
            if(stepsElapsed >= rideLength)
            {
                started = false;
                return true;
            }
        }
        return false;
    }
}
