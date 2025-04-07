package main.java.com.dp;

public class C_FrogJump {

    int minCost(int[] height) {
        int[] dp = new int[height.length+1];
        for(int i =0;i<height.length;i++)
        {
            dp[i] = -1;
        }
        return deriveCost(height.length-1,height,dp);
    }

    int deriveCost(int index, int[] height,  int[] dp)
    {
        if(index==0)
            return 0;
        if(dp[index]!=-1)
            return dp[index];
        int right= Integer.MAX_VALUE;
        int left = deriveCost(index-1, height,dp)+Math.abs(height[index]-height[index-1]);
        if(index>1) {
            right = deriveCost(index -2 , height, dp)+ Math.abs(height[index] - height[index - 2]);
        }
        return dp[index]=Math.min(left,right);

    }
    int minCostTabDP(int[] height) {
        int[] dp = new int[height.length];
        dp[0] =0;
        for(int index = 1; index <height.length; index++)
        {
            int right= Integer.MAX_VALUE;
            int left = dp[index-1]+Math.abs(height[index]-height[index-1]);
            if(index>1) {
                right = dp[index-2]+ Math.abs(height[index] - height[index - 2]);
            }
            dp[index]=Math.min(left,right);
        }
        return dp[height.length-1];
    }

    static int  minCostTabDPSpaceOptimized(int[] height) {

        int grandF =0;
        if(height.length>1) {
            int father;
            father = Math.abs(height[0] - height[1]);
            for (int index = 2; index < height.length; index++) {

                int f1 = father + Math.abs(height[index] - height[index - 1]);
                int g1 = grandF + Math.abs(height[index] - height[index - 2]);

                grandF = father;
                father = Math.min(f1, g1);

            }
            return father;
        }
        else
            return grandF;
    }

    public static void main(String[] arg) {
        int[] dpArr = new int[]{10,30,40,20,50};
        System.out.println(minCostTabDPSpaceOptimized(dpArr));
    }
}
