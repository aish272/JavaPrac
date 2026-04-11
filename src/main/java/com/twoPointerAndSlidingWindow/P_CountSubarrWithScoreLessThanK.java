package main.java.com.twoPointerAndSlidingWindow;

public class P_CountSubarrWithScoreLessThanK {

    /**
     * <a href="https://leetcode.com/problems/count-subarrays-with-score-less-than-k/description/">2302. Count Subarrays With Score Less Than K</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=wxd3SWgzoKA">Video solution link</a>
     */
    public long countSubarrays(int[] nums, long k) {

        int n = nums.length;
        int l = 0;
        int r = 0;
        long sum = 0;
        long count = 0;
        while (r < n) {
            sum += nums[r];
            while (l <= r && sum * (r - l + 1) >= k) {
                sum -= nums[l];
                l++;
            }

            count += (r - l + 1);
            r++;

        }
        return count;

    }
}
