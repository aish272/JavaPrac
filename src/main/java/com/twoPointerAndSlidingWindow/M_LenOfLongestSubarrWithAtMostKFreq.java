package main.java.com.twoPointerAndSlidingWindow;

import java.util.HashMap;

public class M_LenOfLongestSubarrWithAtMostKFreq {

    /**
     * <a href="https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/">2958. Length of Longest Subarray With at Most K Frequency</a>
     */
    public int maxSubarrayLength(int[] nums, int k) {

        int l = 0;
        int r = 0;
        int len = Integer.MIN_VALUE;
        HashMap<Integer, Integer> hash = new HashMap<>();
        while (r < nums.length) {
            int num = nums[r];
            if (hash.get(num) == null) { //add the val in map
                hash.put(num, 1);
            } else if (hash.get(num) == k) { //if the val is alreday equal to k. Shrink the window.
                while (nums[l] != num) { //Move i to it's next occurence
                    if (hash.get(nums[l]) != null) {
                        hash.put(nums[l], hash.get(nums[l]) - 1); //reduce occurences of all the vals that appear while moving i to next occurence .
                    }
                    l++;
                }
                l++;
            } else {
                hash.put(num, hash.get(num) + 1);
            }
            len = Math.max(len, r - l + 1);
            r++;
        }
        return len;

    }
}
