package main.java.com.math;

public class A_UglyNumber {

    /**
     * <a href="https://leetcode.com/problems/ugly-number/">263. Ugly Number</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=MJcckSfoYdI&list=PLgUwDviBIf0oFON1SRGcMqMIhiZ4EXx_F&index=3">Prime number</a>
     * <a href="https://www.youtube.com/watch?v=LT7XhVdeRyg&list=PLgUwDviBIf0oFON1SRGcMqMIhiZ4EXx_F&index=4">List prime factors</a>
     */
    public boolean isUgly(int n) {
        if(n<=0)
            return false;
        if (n <= 3)
            return true;

        for (int i = 2; i*i <= n; i++) {

            if((n%i==0 && isPrime(i)) && ((i!=2&&i!=3) && i!=5))
            {
                return false;
            }
            else if((n%(n/i)==0 && isPrime(n/i)) && ((i!=2&&i!=3) && i!=5))
            {
                return false;
            }
        }
        return true;

    }

    public boolean isPrime(int num)
    {
        if(num==1)
            return false;
        if(num<=3)
            return true;

        for(int i = 2; i*i<=num; i++)
        {
            if(num%i==0)
                return false;
        }
        return true;
    }

    public boolean isUgly_Optimised(int n) {
        if(n<=0)
            return false;

        while(n%2==0)
        {
            n=n/2;
        }
        while(n%3==0)
        {
            n=n/3;
        }
        while(n%5==0)
        {
            n=n/5;
        }
        return n==1;

    }
}
