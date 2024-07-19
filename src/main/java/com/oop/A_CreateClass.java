package com.oop;

class Cycle
{
    int price;
    boolean headlights;
    boolean gear;
    public void ride()
    {
        System.out.println("Riding my single seater bike....");
    }
}
public class A_CreateClass
{
    public static void main(String[] args) {
        Cycle AshBike = new Cycle();
        AshBike.price = 89;
        AshBike.headlights = false;
        AshBike.gear = false;
        AshBike.ride();
    }
}
