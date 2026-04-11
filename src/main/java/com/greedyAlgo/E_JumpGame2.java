package main.java.com.greedyAlgo;

import java.util.Arrays;

public class E_JumpGame2 {

    /**
     * <a href="https://leetcode.com/problems/jump-game-ii/">45. Jump Game II</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=7SBVnw7GSTk">Video solution link</a>
     */
    public static int jump(int[] nums) {
        int l = 0;
        int r = 0;
        int jumps = 0;
        int upperLimit = Integer.MIN_VALUE;
        while (r < nums.length - 1) {
            for (int i = l; i <= r; i++) {
                upperLimit = Math.max(upperLimit, i + nums[i]);
            }
            l = r + 1;
            r = upperLimit;
            jumps++;
        }
        return jumps;

    }

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));

    }

    public int jumpDp(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int[][] dp = new int[nums.length][nums.length - 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return returnMinJumps(0, 0, nums, dp);
    }

    public int returnMinJumps(int index, int jumps, int[] nums, int[][] dp) {
        if (index >= nums.length - 1) {
            return jumps;
        }
        if (dp[index][jumps] != -1) {
            return dp[index][jumps];
        }
        int mini = Integer.MAX_VALUE;
        for (int i = 1; i <= nums[index]; i++) {
            mini = Math.min(mini, returnMinJumps(index + i, jumps + 1, nums, dp));
        }
        return dp[index][jumps] = mini;
    }
}
