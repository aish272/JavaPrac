package com.javabasics;

import java.util.Scanner;

public class P_Methods {
    static int fact(int factnum)
    {
        int res = 1;
        while (factnum>1)
        {
            res *= factnum;
            factnum--;
        }
        return res;
    }

    static void changeFirstElement(int [] arr)
    {
        arr[0] = 999;
    }

    public static void main(String[] args)
    {
        System.out.println("Enter a number to calculate it's factorial");
        Scanner sc  = new Scanner(System.in);
        int num=sc.nextInt();
        System.out.println("The factorial is "+P_Methods.fact(num));
        int[] arr = {3,7};
        P_Methods.changeFirstElement(arr);
        System.out.println("The first element of arr is "+arr[0]);

    }
}
