package main.java.com.recursion;

public class E_CountGoodNumbers {
    static final int  mod = 1000000007;
    public int countGoodNumbers(long n) {

        long evenCount = (n+1)/2;
        long oddCount = n/2;
        long evenWays = power(4,evenCount);
        long oddWays = power(5,oddCount);
        return (int) (evenWays*oddWays)% mod;
    }

    public long power(int base, long exp)
    {
        long result = 1;
        base = base% mod;
        while(exp>0)
        {
            if((exp&1)==1) {
                result = (result * base) % mod;
            }
            base = (base* base)%mod;
            exp >>=1;

        }
        return result;
    }
}
