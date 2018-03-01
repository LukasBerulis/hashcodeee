package com.company;

import com.company.Interfaces.Ride;
import com.company.Models.Car;

public class Efficiency {
    Car car;
    Ride ride;
    int efficiency;

    public Efficiency(Car car, Ride ride){
        this.car = car;
        this.ride = ride;
        this.efficiency = calculateEfficiency(car, ride);
    }

    public int calculateEfficiency(Car car, Ride ride)
    {
        int eff = 2;
        int xMinus = ride.getX() - car.finish()[0];
        int yMinus = ride.getY() - car.finish()[1];
        int totalDistDiff = Math.abs(xMinus) + Math.abs(yMinus);
        eff+= totalDistDiff;
        if(totalDistDiff <= ride.getS() - Main.currentStep){
            eff-= 2;
        }

             return eff;
    }
    public void recalculateEfficiency(){
        this.efficiency = calculateEfficiency(this.car, this.ride);
    }
}
