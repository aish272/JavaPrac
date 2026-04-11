package main.java.com.dp;

import java.util.Arrays;

public class M_MinFallingPathSum {

    public static int minFallingPathSum(int[][] matrix) {
        int min =Integer.MAX_VALUE;
        for(int col=0;col<matrix[0].length;col++)
        {
            int minVal = returnMinVal(0,col,matrix);
            min = Math.min(minVal,min);
        }
        return min;
    }

    public static int returnMinVal(int row, int col, int[][] matrix)
    {
        if(col<0 || col==matrix[0].length)
            return 100000000;
        if(row==matrix.length-1)
            return matrix[row][col];
        int below = matrix[row][col]+returnMinVal(row+1,col,matrix);
        int left = matrix[row][col]+returnMinVal(row+1,col-1,matrix);
        int right = matrix[row][col]+returnMinVal(row+1,col+1,matrix);
        return Math.min(below,Math.min(left,right));
    }

    public static int minFallingPathSumDp(int[][] matrix) {
        int min =Integer.MAX_VALUE;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int[] arr:dp)
        {
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        for(int col=0;col<matrix[0].length;col++)
        {
            int minVal = returnMinValDp(0,col,matrix,dp);
            min = Math.min(minVal,min);
        }
        return min;
    }

    public static int returnMinValDp(int row, int col, int[][] matrix,int[][] dp)
    {
        if(col<0 || col==matrix[0].length)
            return 100000000;
        if(row==matrix.length-1)
            return matrix[row][col];
        if(dp[row][col]!=Integer.MAX_VALUE)
        {
            return dp[row][col];
        }
        int below = matrix[row][col]+returnMinValDp(row+1,col,matrix,dp);
        int left = matrix[row][col]+returnMinValDp(row+1,col-1,matrix,dp);
        int right = matrix[row][col]+returnMinValDp(row+1,col+1,matrix,dp);
        return dp[row][col]=Math.min(below,Math.min(left,right));
    }
    public static void main(String[] args) {
        // Define the points for each activity on each day
        int[][] points = {{2, 1, 3},
                {6, 5, 4},
                {7,8,9}
        };
        System.out.println(minFallingPathSum(points)); // Calculate and print the maximum points
        System.out.println(minFallingPathSumDp(points)); // Calculate and print the maximum points
    }
}
