package com.javabasics;

public class F_Associativity {
    public static void main(String[] args)
    {
        int a = 9;
        System.out.println(++a);
        System.out.println(a++);
        System.out.println(--a);
        System.out.println(a--);

        int b=9;
        System.out.println(a--);
        System.out.println(++a);
        System.out.println(a++);
        System.out.println(--a);
    }
}
