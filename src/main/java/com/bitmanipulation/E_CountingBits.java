package main.java.com.bitmanipulation;

public class E_CountingBits {

    public static int[] countBits(int n) {

        if(n==0)
            return new int[]{0};

        int[] ans = new int[n+1];
        ans[0] = 0;
        for(int i =1; i<=n;i++)
        {
            ans[i] = returnCountOfBits(i);
        }
        return ans;

    }

    public static int returnCountOfBits(int num)
    {
        int count = 0;
        while(num!=1)
        {
            int remainder = num%2;
            if(remainder==1)
            {
                count++;
            }
            num /=2;
        }
        return count+1;
    }

    public static void main(String[] args) {
        countBits(1);
    }
}
