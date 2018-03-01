package com.company;

import com.company.Interfaces.ICar;
import com.company.Interfaces.IRide;
import com.company.Interfaces.Ride;

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
            rides.add(new Ride(rs[0], rs[1], rs[2], rs[3], rs[4], rs[5], rs[6]));
        }
        
        //apskaiciuojam pradinius naudingumus


        while(currentStep != T){
            for(Car car: cars){
                for(Ride ride: ride){

                }
            }




            currentStep++;
        }


    }
}
