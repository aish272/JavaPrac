package com.javabasics;
import java.util.Scanner;

public class D_PracticeSet {
    public static void main(String args[])
    {
        //Q1
        short a = 0, b = 9, c = 3;
        short total = (short) (a + b + c);
        System.out.println("The sum is "+total);

        //Q3
        String name;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter you name here: ");
        name = sc.next();
        System.out.println("Hello "+name);

        //Q4
        float distInKM;
        System.out.print("Enter the distance in KMs: ");
        distInKM = sc.nextInt();
        System.out.println("The distance in miles is: "+distInKM*0.6);

        //Q5
        System.out.print("Enter a number: ");
        boolean isInt = sc.hasNextInt();
        System.out.println("The number is an integer: "+isInt);

    }

}
