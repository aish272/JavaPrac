package main.java.com.dp;

import java.util.Arrays;

public class V_CoinChange_II {
    /**
     * <a href="https://leetcode.com/problems/coin-change-ii/">518. Coin Change II</a>
     */


    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return returnNumOfCombo(amount, coins, 0, dp);
    }

    public int returnNumOfCombo(int amount, int[] coins, int index, int[][] dp) {

        if (amount == 0) return 1;
        if (index == coins.length) {
            return 0;
        }
        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }
        int take = 0;
        if (amount - coins[index] >= 0) {
            take = returnNumOfCombo(amount - coins[index], coins, index, dp);
        }
        int notTake = returnNumOfCombo(amount, coins, index + 1, dp);
        return dp[index][amount] = take + notTake;

    }


}
