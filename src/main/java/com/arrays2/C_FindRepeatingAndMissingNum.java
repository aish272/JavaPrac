package main.java.com.arrays2;

public class C_FindRepeatingAndMissingNum {

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] hash = new int[(grid.length*grid.length)+1];
        int[] ans = new int[2];
        for (int[] ints : grid) {
            for (int innerCounter = 0; innerCounter < grid[0].length; innerCounter++) {
                hash[ints[innerCounter]]++;
            }
        }

        for(int index=1;index< hash.length;index++)
        {
            if(hash[index]==2)
            {
                ans[0] = index;
            } else if (hash[index]==0) {
                ans[1] = index;
            }
        }
        return ans;
    }
}
