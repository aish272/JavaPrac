package main.java.com.twoPointerAndSlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q_CountCompleteSubarrInArray {

    /**
     * <a href="https://leetcode.com/problems/count-complete-subarrays-in-an-array/description/">2799. Count Complete Subarrays in an Array</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=t8kDspIQyFQ&t=648s">Video solution link</a>
     */

    public int countCompleteSubarrays(int[] nums) {

        Set<Integer> s = new HashSet<>();
        for (int num : nums) {
            s.add(num);
        }
        int uniqueEle = s.size();

        int l = 0;
        int r = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (r < nums.length) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            while (l <= r && map.size() == uniqueEle) {
                count += nums.length - r;
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0) map.remove(nums[l]);
                l++;

            }
            r++;
        }
        return count;

    }
}
