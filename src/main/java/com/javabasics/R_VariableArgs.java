package com.javabasics;

public class R_VariableArgs {

    static void subSum(int SubBy, int ...SumBy )
    {
        int result=0;
        for(byte i=0;i<SumBy.length;i++)
        {
            result += SumBy[i];
        }
        result -= SubBy;
        System.out.println("Result: "+result);
    }
    static void subSum1(int ...SumBy) //Given a diff name, to not cause ambiguity. Refer main code in JavaCWH
    {
        int result =0;
        for(byte i=0;SumBy.length>i;i++)
        {
            result += SumBy[i];
        }
        System.out.println("Result: "+result);
    }
    public static void main(String[] args)
    {
        R_VariableArgs.subSum1(9,7,8);
        R_VariableArgs.subSum(9,88,9);
    }
}
