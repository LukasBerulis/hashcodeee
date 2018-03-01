package com.company.Interfaces;

public class Ride{
    int index;
    int a;
    int b;
    int x;
    int y;
    int s;
    int f;

    public Ride(int index, int a, int b, int x, int y, int s, int f)
    {
        this.index = index;
        this.a = a;
        this.b = b;
        this.x = x;
        this.y = y;
        this.s = s;
        this.f = f;
    }
    public int getIndex(){
        return this.index;
    }
    public int getA() {
        return this.a;
    }

    public int getB() {
        return this.b;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getS() {
        return this.s;
    }

    public int getF() {
        return this.f;
    }
}
