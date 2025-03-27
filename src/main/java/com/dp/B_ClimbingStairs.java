package main.java.com.dp;

public class B_ClimbingStairs {

    public int climbStairs1(int n) {

        if(n<=1)
            return 1;
        int left = climbStairs1(n-1);
        int right = climbStairs1(n-2);
        return left+right;
    }

    public int climbStairs(int n) {
        if(n<=1)
            return 1;
        int grandF = 1;
        int father = 1;
        for(int i =2;i<=n;i++)
        {
            int ways = grandF +father;
            grandF = father;
            father = ways;
        }
        return father;
    }


}
