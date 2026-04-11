package main.java.com.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Y_LongestIncreasingSubsequence {

    /**
     * <a href="https://leetcode.com/problems/longest-increasing-subsequence/">300. Longest Increasing Subsequence</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=DG50PJIx2SM&t=1739s">Video solution link</a>
     */
    public int lengthOfLIS(int[] nums) {
        return getLengthOfLIS(nums, 0, new ArrayList<>());
    }

    public int getLengthOfLIS(int[] nums, int index, List<Integer> l) {
        if (index == nums.length)
            return l.size();

        int pick = 0;
        if (l.isEmpty() || l.get(l.size() - 1) < nums[index]) {
            l.add(nums[index]);
            pick = getLengthOfLIS(nums, index + 1, l);
            l.remove(l.size() - 1);
        }
        int notPick = getLengthOfLIS(nums, index + 1, l);
        return Math.max(pick, notPick);
    }

    public static int lengthOfLIS2(int[] nums) {
        return getLengthOfLIS(nums, 0, -1);
    }

    public static int getLengthOfLIS(int[] nums, int index, int prevIndex) {
        if (index >= nums.length)
            return 0;

        int pick = 0;
        if (prevIndex == -1 || nums[prevIndex] < nums[index]) {
            pick = 1 + getLengthOfLIS(nums, index + 1, index);
        }
        int notPick = getLengthOfLIS(nums, index + 1, prevIndex);
        return Math.max(pick, notPick);
    }

    public int lengthOfLISDP(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return getLengthOfLIS(nums, 0, -1, dp);
    }

    public int getLengthOfLIS(int[] nums, int index, int prevIndex, int[][] dp) {
        if (index >= nums.length)
            return 0;
        if (prevIndex != -1) {
            if (dp[index][prevIndex] != -1)
                return dp[index][prevIndex];
        }
        int pick = 0;
        if (prevIndex == -1 || nums[prevIndex] < nums[index]) {
            pick = 1 + getLengthOfLIS(nums, index + 1, index, dp);
        }
        int notPick = getLengthOfLIS(nums, index + 1, prevIndex, dp);
        if (prevIndex != -1) {
            dp[index][prevIndex] = Math.max(pick, notPick);
        }
        return Math.max(pick, notPick);
    }

    public static void main(String[] args) {
        lengthOfLIS2(new int[]{10,9,2,5,3,7,101,18});
    }
}
