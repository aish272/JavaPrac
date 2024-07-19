package com.javabasics;

import org.jetbrains.annotations.NotNull;

public class Q_MethodOverloading {
    void changeNum(int x)
    {
        x=0;
    }
    void changeNum(int @NotNull [] arr)
    {
        arr[0] = 7;
    }

    public static void main(String[] args)
    {
        Q_MethodOverloading obj = new Q_MethodOverloading();
        int num = 90;
        obj.changeNum(num);
        int[] arr = {4,6,8};
        obj.changeNum(arr);
        System.out.println("Num's changed: "+(num!=90));//Pass by value
        System.out.println("Arr's first element changed: "+(arr[0]!=4));// Pass by reference
    }
}
