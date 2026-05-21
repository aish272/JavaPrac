package main.java.com.twoPointerAndSlidingWindow;

import java.util.Arrays;

public class V_KRadiusSubarrayAvg {

    /**
     * <a href="https://leetcode.com/problems/k-radius-subarray-averages/description/">2090. K Radius Subarray Averages</a>
     */
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        long windowLen = k + 1 + k;
        if (windowLen > n) {
            return ans;
        }
        int start = k; //first index which can have an avg
        int end = n - k - 1; //last index which can have an avg
        long avg = 0;
        for (int i = 0; i < windowLen; i++) {
            avg += nums[i];
        }
        int ind = 0;
        for (int i = start; i <= end; i++) {
            ans[i] = (int)(avg / windowLen);
            //shifting the window towards right
            avg -= nums[ind]; // removing ele from left
            if(windowLen + ind<n)
                avg += nums[(int)windowLen + ind]; // adding ele from right
            ind++;

        }
        return ans;
    }
}
