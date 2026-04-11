package main.java.com.bitmanipulation;

public class A_PowerOfTwo {

    /**
     * <a href="https://leetcode.com/problems/power-of-two/description/">231. Power of Two</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=nttpF8kwgd4">Video solution link</a>
     */

    public boolean isPowerOfTwo(int n) {
        if(n==1)
            return true;
        double num = n;
        while(num!=0)
        {
            if(num==2.0)
            {
                return true;
            }
            num = num/2.0;
        }
        return false;

    }
    public boolean isPowerOfTwoUsingBitManipulation(int n) {
        return n > 0 && (n & n - 1) == 0;
    }
}
