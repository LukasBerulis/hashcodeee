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
        int startStep = Main.currentStep;
        int finishStep = ride.getF();
       // int eff = 2;
        int xMinus = ride.getA() - car.finish()[0];
        int yMinus = ride.getB() - car.finish()[1];
        int xTravel = ride.getX() - ride.getA();
        int yTravel = ride.getY() - ride.getB();

        int totalDistDiff = Math.abs(xMinus) + Math.abs(yMinus);
        int totalRideDiff = Math.abs(xTravel) + Math.abs(yTravel);

        int totalRealTimeStepFinnish = startStep + totalDistDiff + totalRideDiff;
        int Efficiency = finishStep - totalRealTimeStepFinnish;
        return Efficiency;


//        if(finishStep - startStep >= totalDistDiff + totalRideDiff){
//            return 999999999;
//        }
//        eff+= totalDistDiff;
//        if(totalDistDiff <= ride.getS() - Main.currentStep){
//            eff-= 2;
//        }
//
//             return eff;
    }
    public void recalculateEfficiency(){
        this.efficiency = calculateEfficiency(this.car, this.ride);
    }
}
