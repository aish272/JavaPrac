package main.java.com.kadaneAndBS.BS1;

import java.util.Arrays;

public class A_LongestSubsequenceWithLimitedSum {

    /**
     * <a href="https://leetcode.com/problems/longest-subsequence-with-limited-sum/description/?envType=problem-list-v2&envId=binary-search">2389. Longest Subsequence With Limited Sum</a>
     */
    public int[] answerQueries(int[] nums, int[] queries) {
        int[] ans = new int[queries.length];
        int[] prefixSum = new int[nums.length];
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            prefixSum[i] = sum;
        }
        for (int i = 0; i < queries.length; i++) {
            if (queries[i] >= sum) {
                ans[i] = nums.length;
                continue;
            }
            ans[i] = longestSubSeqLen(prefixSum, queries[i]);

        }
        return ans;

    }

    public int longestSubSeqLen(int[] prefixSum, int query) {
        int low = 0;
        int high = prefixSum.length - 1;
        int res = 0;
        while (high >= low) {
            int mid = (high + low) / 2;
            if (prefixSum[mid] <= query) {
                res = mid + 1;
                low = mid + 1;
            } else high = mid - 1;
        }
        return res;

    }
}
