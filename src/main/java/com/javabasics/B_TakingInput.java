package com.javabasics;
import java.util.Scanner;
public class B_TakingInput
{
    public static void main(String args[])
    {
        Scanner ip = new Scanner(System.in);
        System.out.println("Enter a number: ");
        boolean b1 = ip.hasNextInt();
        System.out.println("b1 = "+b1);// here hastNextInt() indicates that whether the entered value is int or not.

        //Note: In loop hasNextInt() is used to find that whether the data structure has another element or not.
    }
}
