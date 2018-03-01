package com.company;

import com.company.Interfaces.ICar;
import com.company.Interfaces.Ride;
import com.company.Models.Car;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int currentStep = 0;

    public static void main(String[] args) {
        List<String> inputLines = new ArrayList<>();
        try {
            inputLines = Files.readAllLines(Paths.get("testdata.txt"), StandardCharsets.UTF_8);
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
        List<Efficiency> eff = new ArrayList<Efficiency>();


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
        
        //apskaiciuojam pradinius naudingumus


        while(currentStep != T){
            for(Car car: cars){
                for(Ride ride: rides){

                }
            }




            currentStep++;
        }


    }
}
