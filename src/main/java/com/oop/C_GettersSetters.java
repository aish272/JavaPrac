package com.oop;

class Car
{
    private int price;
    private int mileage;
    public void setter(int price,int mileage )
    {
        this.price = price;
        this.mileage = mileage;
    }
    public int getPrice()
    {
        return price;
    }
    public int getMileage()
    {
        return mileage;
    }
}
public class C_GettersSetters {

    public static void main(String[] args)
    {
        Car RangeRover = new Car();
        RangeRover.setter(1000000,20);
        System.out.println("Price: "+RangeRover.getPrice()+" Mileage: "+RangeRover.getMileage());
    }
}
