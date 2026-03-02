package main.java.com.recursion;

import java.util.Arrays;

public class L_LongestSubsequenceWithLimitedSum {

    /**
     * <a href="https://leetcode.com/problems/longest-subsequence-with-limited-sum/description/?envType=problem-list-v2&envId=binary-search">2389. Longest Subsequence With Limited Sum</a>
     */
    public static int[] answerQueries(int[] nums, int[] queries) {
        int[] ans = new int[queries.length];
        int total = 0;
        for (int num : nums) {
            total = +num;
        }
        for (int i = 0; i < queries.length; i++) {
            if (total >= queries[i]) ans[i] = longestSubSeqLen(nums, queries[i], 0, 0);
            else {
                ans[i] = nums.length;
            }
        }
        return ans;

    }

    public static int longestSubSeqLen(int[] nums, int sum, int index, int picked) {
        if (index == nums.length && sum > 0) return picked;
        if (sum <= 0) return sum == 0 ? picked : picked - 1;
        int pick = 0;
        if (sum >= nums[index]) {
            pick = longestSubSeqLen(nums, sum - nums[index], index + 1, picked + 1);
        }
        int notPick = longestSubSeqLen(nums, sum, index + 1, picked);
        return Math.max(pick, notPick);

    }

    public static void main(String[] args) {
        System.out.println(answerQueries(new int[]{4, 5, 2, 1}, new int[]{3, 10, 21}));
    }

    public int[] answerQueriesDP(int[] nums, int[] queries) {
        int[] ans = new int[queries.length];
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        for (int i = 0; i < queries.length; i++) {
            if (total >= queries[i]) {
                int[][] dp = new int[queries[i] + 1][nums.length];
                for (int[] arr : dp) {
                    Arrays.fill(arr, -1);
                }
                ans[i] = longestSubSeqLen(nums, queries[i], 0, 0, dp);
            } else {
                ans[i] = nums.length;
            }
        }
        return ans;

    }

    public int longestSubSeqLen(int[] nums, int sum, int index, int picked, int[][] dp) {
        if (index == nums.length) return picked;
        if (sum <= 0) return sum == 0 ? picked : picked - 1;
        if (dp[sum][index] != -1) {
            return dp[sum][index];
        }
        int pick = 0;
        if (sum >= nums[index]) {
            pick = longestSubSeqLen(nums, sum - nums[index], index + 1, picked + 1, dp);
        }
        int notPick = longestSubSeqLen(nums, sum, index + 1, picked, dp);
        return dp[sum][index] = Math.max(pick, notPick);

    }
}
