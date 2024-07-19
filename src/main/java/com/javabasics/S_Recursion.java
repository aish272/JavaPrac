package com.javabasics;

public class S_Recursion
{
    static int fibo(int NthTerm) //1,1,2,3,5,8,13,21,34
    {
        if(NthTerm==1 || NthTerm==2)
            return  1;
        else
        {
            return fibo(NthTerm-1)+fibo(NthTerm-2);
        }
    }
    static int fact(int Num)
    {
        if(Num==0 || Num==1)
        {
            return 1;
        }
        else
        {
            return Num*fact(Num-1);
        }
    }
    public static void main(String[] args)
    {
        int result = S_Recursion.fact(8);
        System.out.println("Factorial of 8: "+result);

        result = S_Recursion.fibo(9);
        System.out.println("The 9th term in fibonacci series is: "+fibo(9));

    }
}


