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
             return 0;
    }
}
