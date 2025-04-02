package main.java.com.dp;

import java.util.Arrays;

public class H_UniquePaths {

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] arr:dp) {
            Arrays.fill(arr,-1);
        }
       return deriveUniquePaths(m-1,n-1,dp);
    }

    public static int deriveUniquePaths(int m, int n, int[][]dp){
        if(m==0 & n==0)
            return 1;
        if(m<0 || n<0)
            return 0;
        if(dp[m][n]!=-1)
            return dp[m][n];
        int left = deriveUniquePaths(m,n-1,dp);
        int up = deriveUniquePaths(m-1,n,dp);
        return left+up;
    }

    public static int uniquePathsTab(int m, int n) {
       int[][] dp = new int[m][n];
        for (int[]row:dp) {
            Arrays.fill(row,-1);
        }
        for(int row = 0; row <m; row++) {
            for (int col = 0; col < n; col++)
            {
                if(row==0&&col==0)
                {
                    dp[row][col]=1;
                }
                else
                {
                    int up=0;
                    int left=0;
                    if(row>0)
                    {
                        up = dp[row-1][col];
                    }
                    if(col>0)
                    {
                        left = dp[row][col-1];
                    }
                    dp[row][col] = up+left;
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static int uniquePathsTabSpaceOptimized(int m, int n) {
        int[] dp = new int[n];
        for(int row = 0; row <m; row++) {
            int[] temp = new int[n];
            for (int col = 0; col < n; col++)
            {
                if(row==0&&col==0)
                {
                    temp[row]=1;
                }
                else
                {
                    int up=0;
                    int left=0;
                    if(row>0)
                    {
                        up = dp[col];
                    }
                    if(col>0)
                    {
                        left = temp[col-1];
                    }
                    temp[col] = up+left;
                }
            }
            for(int i =0;i<n;i++)
            {
                dp[i] = temp[i];
            }
        }
        return dp[n-1];
    }

    public static void main(String args[]) {
        int m = 3;
        int n = 2;

        // Call the countWays function and print the result
        //System.out.println(uniquePathsTab(m, n));
        System.out.println(uniquePathsTabSpaceOptimized(m, n));
    }
}
