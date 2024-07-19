package com.javabasics;

public class O_PracticeSet6 {

    public static void main(String[] main)
    {
        //Q 6,7,8
        byte[] RevArr = {2,7,3,7,90,4};
        boolean checkSorted = true;
        byte min = RevArr[0];
        byte max = RevArr[0];
        for(byte i=0;i<RevArr.length-1;i++)
        {
            if(RevArr[i]>RevArr[i+1])
            {
                checkSorted = false;
            }
            if(min>RevArr[i+1])
            {
                min = RevArr[i+1];
            }
            if(max<RevArr[i+1])
            {
                max = RevArr[i+1];
            }

        }
        System.out.println("Max: "+max+" Min: "+min+" IsSorted: "+checkSorted);
        //Q5
        int half_len = Math.floorDiv(RevArr.length, 2);
        for(byte i=0;i<half_len;i++)
        {
            byte temp = RevArr[RevArr.length-1-i];
            RevArr[RevArr.length-1-i] = RevArr[i];
            RevArr[i] = temp;

        }
        byte i=0;
        while(i<RevArr.length)
        {
            System.out.println(RevArr[i]);
            i++;
        }
    }
}
