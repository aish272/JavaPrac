package main.java.com.dp;

import java.util.Arrays;

public class K_MinPathSum {

    //Logic by me
    public int minPathSum(int[][] grid) {
        int[] arrMinSum = new int[1];
        arrMinSum[0] = Integer.MAX_VALUE;
        getMinPathSum(grid.length-1,grid[0].length-1,grid,arrMinSum,0);
        return arrMinSum[0];
    }

    public static void getMinPathSum(int row, int col, int[][] grid, int[] minSum, int sum)
    {
        if(row<0|| col<0)
            return;
        if(row==0&& col==0) {
            sum = sum + grid[row][col];
            minSum[0] = Math.min(sum, minSum[0]);
        }

        sum = sum+grid[row][col];
        getMinPathSum(row-1,col,grid,minSum,sum);
        getMinPathSum(row,col-1,grid,minSum,sum);
    }

    public static int minPathSumDp(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int[] arr: dp)
        {
            Arrays.fill(arr,-1);
        }
        return getMinPathSumDp(grid.length-1,grid[0].length-1,grid,dp);
    }

    public static int getMinPathSumDp(int row, int col, int[][] grid, int[][] dp)
    {
        if(row==0&& col==0) {
            return grid[row][col];
        }
        if(row<0|| col<0)
            return (int) Math.pow(10, 9);
        if(dp[row][col]!=-1)
            return dp[row][col];
        int up = grid[row][col]+ getMinPathSumDp(row-1,col,grid,dp);
        int left = grid[row][col]+ getMinPathSumDp(row,col-1,grid,dp);
        return dp[row][col]=Math.min(up, left);
    }

    public static int minPathSumTab(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int row=0;row<grid.length;row++)
        {
            for(int col=0;col<grid[0].length;col++)
            {
                if(row==0 && col==0)
                    dp[row][col] = grid[row][col];
                else
                {
                    int up =Integer.MAX_VALUE;
                    int left=Integer.MAX_VALUE;
                    if(row>0) {
                        up = grid[row][col] + dp[row - 1][col];
                    }
                    if(col>0) {
                        left = grid[row][col] + dp[row][col - 1];
                    }
                    dp[row][col]=Math.min(up, left);

                }
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }

    public static int minPathSumTabSpaceOptimised(int[][] grid) {
        int[] dp = new int[grid[0].length];
        for(int row=0;row<grid.length;row++)
        {
            int[] temp = new int[grid[0].length];
            for(int col=0;col<grid[0].length;col++)
            {
                if(row==0 && col==0)
                    temp[col] = grid[row][col];
                else
                {
                    int up =Integer.MAX_VALUE;
                    int left=Integer.MAX_VALUE;
                    if(row>0) {
                        up = grid[row][col] + dp[col];
                    }
                    if(col>0) {
                        left = grid[row][col] + temp[col - 1];
                    }
                    temp[col]=Math.min(up, left);
                }
            }
            dp = temp;
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        // Define the points for each activity on each day
        int[][] points = {{1, 3, 1},
                {1, 5, 1}};
        System.out.println(minPathSumDp(points)); // Calculate and print the maximum points
        System.out.println(minPathSumTab(points)); // Calculate and print the maximum points
        System.out.println(minPathSumTabSpaceOptimised(points)); // Calculate and print the maximum points
    }



 }
