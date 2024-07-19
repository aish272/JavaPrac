package com.javabasics;

import java.util.Scanner;

public class C_Exercise {
    public static void main (String [] args)
    {
        short En, Hin, Phy, Chem, Maths, total;
        float avg;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the marks of English: ");
        En = sc.nextShort();
        System.out.println("Enter the marks of Hindi: ");
        Hin = sc.nextShort();
        System.out.println("Enter the marks of Physics: ");
        Phy = sc.nextShort();
        System.out.println("Enter the marks of Maths: ");
        Maths = sc.nextShort();
        System.out.println("Enter the marks of Chemistry: ");
        Chem = sc.nextShort();
        total = (short) (Chem+Phy+Maths+Hin+En);
        avg = total/5;
        System.out.println("The avg marks are: "+avg);


    }
}
