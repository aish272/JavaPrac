package main.java.com.twoPointerAndSlidingWindow;

public class H_SubArrayProductLessThank {

    /**
     * <a href="https://leetcode.com/problems/subarray-product-less-than-k/">713. Subarray Product Less Than K</a>
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1)
            return 0;
        int total = 0;
        int prod = 1;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k && left < nums.length) {
                prod /= nums[left];
                left++;
            }
            if (left <= right) {
                total += (right - left + 1);
            }

        }
        return total;

    }
}
