package main.java.com.arrays2;

import java.util.HashMap;
import java.util.Map;

public class R_ContiguousArray {

    /**
     * <a href="https://leetcode.com/problems/contiguous-array/">525. Contiguous Array</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=AcSWGXBu-Xo">Video solution link</a>
     */

    public int findMaxLength(int[] nums) {

        Map<Integer, Integer> cumulativeSumWithIndex = new HashMap<>();
        int prefixSum = 0;

        //make all 0s -1
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }
        int len = 0;
        //sum the elements in the array one by one and store in prefixSum
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            //already seen the sum in the past and encountered it again in the current index.
            //It means the window from seenBeforeSumIndex+1 to current index amounts to sum 0.
            if (cumulativeSumWithIndex.containsKey(prefixSum)) {
                len = Math.max(len, i - cumulativeSumWithIndex.get(prefixSum)); // calculate the length of the window
            } else if (prefixSum == 0) {
                len = Math.max(len, i + 1); //from the start till i sum is 0, so length till i will be considered. i+1 because we use 0-based indexing
            } else {
                cumulativeSumWithIndex.put(prefixSum, i); //store the sum if not seen before
            }
        }

        return len;

    }
}
