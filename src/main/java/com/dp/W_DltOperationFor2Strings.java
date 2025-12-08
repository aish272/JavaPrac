package main.java.com.dp;

import java.util.Arrays;

public class W_DltOperationFor2Strings {

    /**
     * <a href="https://leetcode.com/problems/delete-operation-for-two-strings/description/">583. Delete Operation for Two Strings</a>
     */
    public int minDistance(String word1, String word2) {
        int ind1 = word1.length();
        int ind2 = word2.length();
        int[][] dp = new int[ind1][ind2];
        for(int[] arr:dp)
        {
            Arrays.fill(arr,-1);
        }

        int lcsLen = returnLCSLen(ind1-1, ind2-1, word1, word2, dp);
        return (ind1 - lcsLen + ind2 - lcsLen);

    }

    public int returnLCSLen(int ind1, int ind2, String word1, String word2, int[][] dp) {
        if (ind1 < 0 || ind2 < 0) {
            return 0;
        }
        if (dp[ind1][ind2] != -1) {
            return dp[ind1][ind2];
        }
        if (word1.charAt(ind1) == word2.charAt(ind2)) {
            return dp[ind1][ind2] = 1 + returnLCSLen(ind1 - 1, ind2 - 1, word1, word2, dp);
        } else {
            return dp[ind1][ind2] = Math.max(returnLCSLen(ind1, ind2 - 1, word1, word2, dp),
                    returnLCSLen(ind1 - 1, ind2, word1, word2, dp));
        }
    }
}
