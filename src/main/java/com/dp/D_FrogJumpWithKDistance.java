package main.java.com.dp;

public class D_FrogJumpWithKDistance {

    static int minimizeCost(int[] height, int k) {
        int[] dp = new int[height.length+1];
        for(int i =0;i<=height.length;i++)
        {
            dp[i] = -1;
        }
        return deriveCost(height.length-1,height,dp,k);
    }

    static int deriveCost(int index, int[] height, int[] dp, int k)
    {
        if(index==0)
            return 0;
        if(dp[index]!=-1)
            return dp[index];
        int min = Integer.MAX_VALUE;
        for(int jump=1;jump<=k;jump++) {
            int cost = 0;
            if (index - jump >= 0) {
                cost = deriveCost(index - jump, height, dp, k) + Math.abs(height[index] - height[index - jump]);
                min = Math.min(min, cost);
            }
            else
            {
                break;
            }

        }
        return dp[index]=min;

    }


    public static void main(String[] arg) {
        int[] dpArr = new int[]{10,30,40,20,50};
        System.out.println(minimizeCost(dpArr,3));
    }
}
