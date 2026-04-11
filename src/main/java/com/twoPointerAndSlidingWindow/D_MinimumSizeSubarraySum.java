package main.java.com.twoPointerAndSlidingWindow;

public class D_MinimumSizeSubarraySum {
/**
 * <a href="https://leetcode.com/problems/minimum-size-subarray-sum/description/?envType=problem-list-v2&envId=prefix-sum">209. Minimum Size Subarray Sum</a>
 */
    public static int minSubArrayLen(int target, int[] nums) {

        int[] prefixSum = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            prefixSum[i] = sum;
        }
        int left = 0;
        int right = 0;
        int ans = Integer.MAX_VALUE;
        while (right <= nums.length - 1 && prefixSum[right] < target) {
            right++;
        }
        while (right <= nums.length - 1) {

            while (left <= nums.length - 1 && prefixSum[right] - prefixSum[left] >= target) {
                ans = Math.min(ans, right - left+1);
                left++;

            }
            if(prefixSum[right] - prefixSum[left] + nums[left]>= target)
                ans = Math.min(ans, right - left+1);


            right++;

        }

        if (prefixSum[prefixSum.length - 1] < target)
            return 0;

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(15,new int[]{5,1,3,5,10,7,4,9,2,8}));

    }
}
