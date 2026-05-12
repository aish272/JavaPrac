package main.java.com.dp2;

import java.util.Arrays;

public class G_BurstBalloons {

    /**
     * <a href="https://leetcode.com/problems/burst-balloons/">312. Burst Balloons</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=Yz4LlDSlkns&t=638s">Video solution link</a>
     */
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n + 2];
        newNums[0] = 1;
        newNums[n + 1] = 1;
        System.arraycopy(nums, 0, newNums, 1, n);

        int[][] dp = new int[n + 2][n + 2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return burst(newNums, 1, newNums.length - 2, dp);
    }

    public int burst(int[] nums, int i, int j, int[][] dp) {

        if (i > j)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int maxCoins = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) {
            int coins = nums[i - 1] * nums[k] * nums[j + 1];
            int remainingCoins = burst(nums, i, k - 1, dp) + burst(nums, k + 1, j, dp);
            maxCoins = Math.max(maxCoins, coins + remainingCoins);
        }

        return dp[i][j] = maxCoins;

    }
}
