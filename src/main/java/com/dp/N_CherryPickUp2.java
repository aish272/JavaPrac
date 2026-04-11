package main.java.com.dp;

import java.util.Arrays;

public class N_CherryPickUp2 {

    public int cherryPickup(int[][] grid) {
        int[][][] dp = new int[grid.length][grid[0].length][grid[0].length];
        for(int[][]arr1:dp)
        {
            for(int[] arr:arr1)
            {
                Arrays.fill(arr,-1);
            }
        }
        return returnMaxCherryPickedVal(0,0,grid[0].length-1,grid,dp);
    }

    public int returnMaxCherryPickedVal(int row, int col1, int col2,int[][] grid, int[][][] dp )
    {
        if(col1<0||col2<0||col1==grid[0].length||col2==grid[0].length)
        {
            return -100000000;
        }
        if(row== grid.length-1)
        {
            if(col1==col2)
                return grid[row][col1];
            else
                return grid[row][col1]+grid[row][col2];
        }
        if(dp[row][col1][col2]!=-1)
            return dp[row][col1][col2];
        int max = Integer.MIN_VALUE;
        for(int way=-1;way<=1;way++)
        {
            for(int way1 = -1; way1 <=1; way1++)
            {
                int val=0;
                if(col1==col2)
                    val = grid[row][col1];
                else
                    val = grid[row][col1]+grid[row][col2];
                val +=returnMaxCherryPickedVal(row+1,col1+way,col2+way1,grid,dp);
                max = Math.max(max,val);
            }
        }
        return dp[row][col1][col2]=max;
    }
}
