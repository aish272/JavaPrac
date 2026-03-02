package main.java.com.kadaneAndBS.BS1;

public class Z_CountNegatives {

    /**
     * <a href="https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/description/">1351. Count Negative Numbers in a Sorted Matrix</a>
     */
    public int countNegatives(int[][] grid) {

        int row =0;
        int sum = 0;
        for(;row<grid.length;row++)
        {
            int low = 0;
            int high = grid[0].length-1;
            while(high>=low)
            {
                int mid = (high+low)/2;
                int num = grid[row][mid];
                if(num<0)
                {
                    if(mid==0 || grid[row][mid-1]>=0)
                    {
                        sum+= (grid[0].length-mid);
                        break;
                    }
                    high = mid-1;
                }
                else
                {
                    low = mid +1;
                }
            }
        }
        return sum;

    }
}
