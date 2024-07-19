package com.javabasics;

public class M_Array
{
    public static void main(String[] args)
    {
        String[] str = {"Swim","Dance","Act","Mimic","Sing"};
        for(String interest: str)
        {
            System.out.println(interest);

        }

        String[] str1 = new String[3];
        str1[0] = "Paul";
        str1[1] = "Ruth";
        str1[2] = "Kourtney";
        for(byte i=0;i< str1.length;i++)
        {
            System.out.println(str1[i]);
        }

    }
}
