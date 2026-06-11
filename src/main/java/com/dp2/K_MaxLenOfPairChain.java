package main.java.com.dp2;

import java.util.Arrays;

public class K_MaxLenOfPairChain {

    /**
     * <a href="https://leetcode.com/problems/maximum-length-of-pair-chain/">646. Maximum Length of Pair Chain</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=DlgGx8GRo9M&list=PLpIkg8OmuX-JhFpkhgrAwZRtukO0SkwAt&index=13">Video solution link</a>
     */
    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int[][] dp = new int[pairs.length][pairs.length];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return getLongestChain(pairs, 0, -1, dp);

    }

    public static int getLongestChain(int[][] pairs, int index, int prev, int[][] dp) {
        if (index == pairs.length)
            return 0;

        if (prev > -1) {
            if (dp[index][prev] != -1)
                return dp[index][prev];
        }
        int pick = 0;
        if (prev == -1 || pairs[prev][1] < pairs[index][0]) {
            pick = 1 + getLongestChain(pairs, index + 1, index, dp);
        }

        int notPick = getLongestChain(pairs, index + 1, prev, dp);

        if (prev > -1) {
            dp[index][prev] = Math.max(pick, notPick);
        }
        return Math.max(pick, notPick);
    }

    public int findLongestChainTab(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int[] dp = new int[pairs.length];
        int maxLen = Integer.MIN_VALUE;

        Arrays.fill(dp, 1); //by default the len of chain would be 1 at each index as would only consider the current element in the begining.

        for (int i = 0; i < pairs.length; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1); //dp[j] + 1 = already existing chain at j and add 1 to represent the current index pairs[i]

                    maxLen = Math.max(dp[i], maxLen);
                }
            }
        }
        if (maxLen == Integer.MIN_VALUE)
            return 1;
        return maxLen;

    }


    public static void main(String[] args) {
        System.out.println(findLongestChain(new int [][] {{1,2},{7,8},{4,5}}));
    }
}
