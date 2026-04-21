package main.java.com.twoPointerAndSlidingWindow;

import java.util.Arrays;

public class X_FindThePowerOfKSizeSubarrays {

    /**
     * <a href="https://leetcode.com/problems/find-the-power-of-k-size-subarrays-i/description/">3254. Find the Power of K-Size Subarrays I</a>
     */
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;

        int[] ans = new int[n - k + 1];
        Arrays.fill(ans, -1);
        if (k > n)
            return ans;

        boolean[] isElementMoreThanPrev = new boolean[nums.length];
        Arrays.fill(isElementMoreThanPrev, false); // initially mark everything false

        isElementMoreThanPrev[0] = true; //there is no element before zero so marking true
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] + 1 == nums[i]) {
                isElementMoreThanPrev[i] = true; //if prev ele is lesser mark true
            }
        }

        int countFalse = 0;

        for (int i = 0; i < k; i++) {
            if (isElementMoreThanPrev[i] == false) {
                countFalse++;
            }
        }
        if (countFalse == 0) {
            ans[0] = nums[k - 1];
        }
        int left = 1;
        int right = k;
        while (right < n) {
            //shift the window

            //remove the left the element from the count
            if (isElementMoreThanPrev[left - 1] == false) {
                countFalse--;
            }
            //first element will always be true because the ascending order validation starts from here
            if (isElementMoreThanPrev[left] == false) {
                isElementMoreThanPrev[left] = true;
                if (countFalse > 0)
                    countFalse--;
            }
            System.out.println(countFalse);
            //include the right element
            if (isElementMoreThanPrev[right] == false) {
                countFalse++;
            }
            System.out.println(countFalse);

            // if everything is sorted, store the last num (highest) at index left

            if (countFalse == 0) {
                ans[left] = nums[right];
            }
            //move the window towards right
            left++;
            right++;
        }
        return ans;

    }
}
