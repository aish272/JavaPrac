package main.java.com.twoPointerAndSlidingWindow2;

import java.util.HashMap;
import java.util.Map;

public class A_NumOfSubarraysWithKDistinctIntegers {

    /**
     * <a href="https://leetcode.com/problems/subarrays-with-k-different-integers/">992. Subarrays with K Different Integers</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=7wYGbV_LsX4&list=PLgUwDviBIf0q7vrFA_HEWcqRqMpCXzYAL&index=11">Video solution link</a>
     */
    public int subarraysWithKDistinct(int[] nums, int k) {

        return getCount(nums, k) - getCount(nums, k - 1);
    }

    public int getCount(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int r = 0;
        int l = 0;
        int count = 0;
        while (r < nums.length) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            while (map.size() > k) {
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0) {
                    map.remove(nums[l]);
                }
                l++;
            }
            count += (r - l) + 1;
            r++;
        }
        return count;
    }
}
