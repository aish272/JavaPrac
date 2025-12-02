package main.java.com.dp;

import java.util.Arrays;

public class U_CoinChange {
    /**
     * <a href="https://leetcode.com/problems/coin-change/">322. Coin Change</a>
     * <br/>
     * <a href="https://takeuforward.org/plus/dsa/problems/minimum-coins?tab=editorial">Video solution link</a>
     */


    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[][] dp = new int[coins.length][amount + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        int ans = returnNumOfCoins(coins, amount, 0, dp);
        if (ans >= (int) 1e9) {
            return -1;
        }
        return ans;

    }

    public int returnNumOfCoins(int[] coins, int amount, int index, int[][] dp) {

        if (index == coins.length - 1) {
            if (amount % coins[index] == 0) return amount / coins[index];
            else return (int) 1e9;
        }
        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }
        int take = (int) 1e9;
        int notTake = 0;
        if (amount - coins[index] >= 0) {
            take = 1 + returnNumOfCoins(coins, amount - coins[index], index, dp);

        }
        notTake = returnNumOfCoins(coins, amount, index + 1, dp);
        return dp[index][amount] = Math.min(take, notTake);
    }


}
