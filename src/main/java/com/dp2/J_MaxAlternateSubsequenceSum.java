package main.java.com.dp2;

import java.util.Arrays;

public class J_MaxAlternateSubsequenceSum {

    /**
     * <a href="https://leetcode.com/problems/maximum-alternating-subsequence-sum/">1911. Maximum Alternating Subsequence Sum</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=bRk0n5JyXSc&list=PLpIkg8OmuX-JhFpkhgrAwZRtukO0SkwAt&index=9">Video solution link</a>
     */
    public long maxAlternatingSum(int[] nums) {
        long[][] dp = new long[nums.length][2];
        for (long[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return getMaxAlternatingSum(nums, 0, true, dp);
    }

    public long getMaxAlternatingSum(int[] nums, int index, boolean evenOrOdd, long[][] dp) {
        if (index == nums.length) {
            return 0;
        }

        int flag = evenOrOdd ? 1 : 0;
        if (dp[index][flag] != -1)
            return dp[index][flag];

        int val = nums[index];
        if (!evenOrOdd) {
            val = -val;
        }

        long take = val + getMaxAlternatingSum(nums, index + 1, !evenOrOdd, dp);
        long notTake = getMaxAlternatingSum(nums, index + 1, evenOrOdd, dp);

        return dp[index][flag] = Math.max(take, notTake);
    }
}
