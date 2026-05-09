package main.java.com.dp2;

import java.util.Arrays;

public class D_EditDistance {

    /**
     * <a href="https://leetcode.com/problems/edit-distance/description/">72. Edit Distance</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=fJaKO8FbDdo&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=34">Video solution link</a>
     */
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        return getMinDist(word1, word2, n - 1, m - 1);
    }

    public int getMinDist(String word1, String word2, int indexW1, int indexW2) {
        if (indexW1 < 0 && indexW2 < 0)
            return 0;

        if (indexW1 < 0)
            return indexW2 + 1; //word1 is exhausted, now perform insert operations equal to remaining chars in word2

        if (indexW2 < 0)
            return indexW1 + 1; //word2 is exhausted, now perform delete operations equal to remaining chars in word1

        if (word1.charAt(indexW1) == word2.charAt(indexW2))
            return getMinDist(word1, word2, indexW1 - 1, indexW2 - 1);

        int delete = 1 + getMinDist(word1, word2, indexW1 - 1, indexW2); //check in next iteration if they matched after deletion
        int replace = 1 + getMinDist(word1, word2, indexW1 - 1, indexW2 - 1); //both matched
        int insert = 1 + getMinDist(word1, word2, indexW1, indexW2 - 1); //move index2 as it matched with inserted char in word1

        return Math.min(delete, Math.min(replace, insert));

    }

    public int minDistanceDp(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n][m];
        for(int[]arr : dp)
        {
            Arrays.fill(arr, -1);
        }
        return getMinDist(word1, word2, n - 1, m - 1, dp);
    }

    public int getMinDist(String word1, String word2, int indexW1, int indexW2, int[][] dp) {
        if (indexW1 < 0 && indexW2 < 0)
            return 0;

        if (indexW1 < 0)
            return indexW2 + 1; //word1 is exhausted, now perform insert operations equal to remaining chars in word2

        if (indexW2 < 0)
            return indexW1 + 1; //word2 is exhausted, now perform delete operations equal to remaining chars in word1

        if(dp[indexW1][indexW2]!=-1)
        {
            return dp[indexW1][indexW2];
        }
        if (word1.charAt(indexW1) == word2.charAt(indexW2))
            return getMinDist(word1, word2, indexW1 - 1, indexW2 - 1, dp);

        int delete = 1 + getMinDist(word1, word2, indexW1 - 1, indexW2, dp); //check in next iteration if they matched after deletion
        int replace = 1 + getMinDist(word1, word2, indexW1 - 1, indexW2 - 1, dp); //both matched
        int insert = 1 + getMinDist(word1, word2, indexW1, indexW2 - 1, dp); //move index2 as it matched with inserted char in word1

        return dp[indexW1][indexW2] = Math.min(delete, Math.min(replace, insert));

    }
}
