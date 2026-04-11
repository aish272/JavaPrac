package main.java.com.twoPointerAndSlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class O_MaxSumOfDistinctSubarrWithLenK {

    /**
     * <a href="https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/">2461. Maximum Sum of Distinct Subarrays With Length K</a>
     **/
    public long maximumSubarraySum(int[] nums, int k) {

        int l = 0;
        int r = 0;
        long ans = 0;
        long sum = 0;
        Set<Integer> window = new HashSet<>();
        while (r < nums.length) {

            while (window.contains(nums[r])) {
                sum -= nums[l];
                window.remove(nums[l]);
                l++;
            }

            sum += nums[r];
            window.add(nums[r]);
            if (window.size() == k) {
                ans = Math.max(ans, sum);
                sum -= nums[l];
                window.remove(nums[l]);
                l++;
            }
            r++;
        }
        return ans;

    }
}
