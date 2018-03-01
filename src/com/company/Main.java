package com.company;

import com.company.Interfaces.ICar;
import com.company.Interfaces.Ride;
import com.company.Models.Car;

import java.io.Console;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {


   public static int currentStep = 0;

    public static void main(String[] args) {
        List<String> inputLines = new ArrayList<>();
        try {
            inputLines = Files.readAllLines(Paths.get("b_should_be_easy.in"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int R, C;
        int F; //vehicles
        int N; //rides
        int bonus;
        int T; //steps
        List<Ride> rides = new ArrayList<Ride>();
        List<Car> cars = new ArrayList<Car>();
        List<Efficiency> effs = new ArrayList<Efficiency>();


        String[] firstLine = inputLines.get(0).split(" ");
        R = Integer.parseInt(firstLine[0]);
        C = Integer.parseInt(firstLine[1]);
        F = Integer.parseInt(firstLine[2]);
        N = Integer.parseInt(firstLine[3]);
        bonus = Integer.parseInt(firstLine[4]);
        T = Integer.parseInt(firstLine[5]);

        for(int i=1; i<inputLines.size(); i++){
            String[] rs = inputLines.get(i).split(" ");
            rides.add(new Ride(i, Integer.parseInt(rs[0]), Integer.parseInt(rs[1]), Integer.parseInt(rs[2]), Integer.parseInt(rs[3]), Integer.parseInt(rs[4]), Integer.parseInt(rs[5])));
        }
        for (int i=0; i<F; i++)
        {
            cars.add(new Car(i));
        }
        //List<Integer>[] answer = new LinkedList<Integer>[F]();
        //apskaiciuojam pradinius naudingumus
        for(Car car: cars){
            for(Ride ride: rides)
            {
               // System.out.println(car.index);
                effs.add(new Efficiency(car, ride));
            }
        }

        while(currentStep < T)
        {
//            /////luko variantas
////            for(Car car: cars){
////                if (car.isFinished())
////                    for(Ride ride: rides)
////                    {
////                        effs.add(new Efficiency(car, ride));
////                    }
////            }
////            //////luko varianto pabaiga
            for (Efficiency eff : effs)
            {
                if (eff.car.isFinished() && !eff.ride.hasHadCar)
                {
                    eff.recalculateEfficiency();
                }
            }
            Collections.sort(effs, Comparator.comparingInt(chair -> chair.efficiency));
            for (Efficiency eff : effs)
            {
               // System.out.println(eff.efficiency);
               // System.out.println(eff.car.index);
                if(!eff.ride.hasHadCar && eff.car.isFinished())
                {
                    //System.out.println(eff.car.index);
                    cars.get(eff.car.index).addRide(eff.ride);
                    cars.get(eff.car.index).setRide(eff.ride);
                    eff.ride.hasHadCar = true;
                }
            }
            //System.out.println("------");
            currentStep++;
        }
        for (Car car : cars)
        {
            for(Ride ride : car.getRides())
            {
                System.out.print(ride.getIndex() + " ");
            }
            System.out.println();
        }


    }
}
