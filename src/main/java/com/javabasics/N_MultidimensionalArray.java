package com.javabasics;

public class N_MultidimensionalArray {
    public static void main(String[] args)
    {
        byte[][] flats = new byte[2][3];
        byte[][] flats1 = {{101, 102, 103}, {104, 105, 106}};
        for (byte flatnum : flats1[0]) //one way to print (this prints only the first array.
        {
            System.out.println(flatnum);
        }
        for(byte outerarray = 0;outerarray<flats1.length;outerarray++)
        {
            for(byte innerarray=0;innerarray<flats[outerarray].length;innerarray++)
            {
                System.out.printf("Floor Number: [%d] Flat Number: [%d]",outerarray,flats1[outerarray][innerarray]);
            }
            System.out.println();
        }
    }
}
