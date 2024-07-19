package com.javabasics;

import java.util.Scanner;

public class J_PracticeSet3 {
    public static void main(String[] args)
    {
        //Q2
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the marks of the 1st sub: ");
        short Sub1 = sc.nextShort();

        System.out.print("Enter the marks of the 2nd sub: ");
        short Sub2 = sc.nextShort();

        System.out.print("Enter the marks of the 3rd sub: ");
        short Sub3 = sc.nextShort();

        float avg = (Sub1+Sub2+Sub3)/3;

        if (avg>=44 && Sub1>=33 && Sub2>=33 && Sub3>=33)
        {
            System.out.println("Woohoo Passed!");
        }
        else
        {
            System.out.println("Failed :(");
        }

        //Q3
        System.out.print("Enter your income: ");
        float income = sc.nextFloat();
        if(income<=2.5)
        {
            System.out.println("Tax free!");
        }
        else if (income>2.5 && income<=5.0)
        {
            System.out.println("Tax: "+ ((5.0-income)*0.05));
        }
        else if (income>5.0 && income<=10.0)
        {
            float tax = (float)((5.0-2.5)*0.05);
            tax= tax + (float) ((income-5)*0.1);
            System.out.println("Tax: "+tax);
        }
        else if (income>10.0)
        {
            float tax = (float)((5.0-2.5)*0.05);
            tax= tax + (float) ((10-5)*0.1);
            tax= tax + (float) ((income-10.0)*0.3);
            System.out.println("Tax: "+tax);
        }
        sc.close();




    }
}
