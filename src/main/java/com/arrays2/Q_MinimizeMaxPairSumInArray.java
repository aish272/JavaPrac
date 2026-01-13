package main.java.com.arrays2;

import java.util.Arrays;

public class Q_MinimizeMaxPairSumInArray {

    /**
     * <a href="https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/">1877. Minimize Maximum Pair Sum in Array</a>
     */
    public int minPairSum(int[] nums) {

        Arrays.sort(nums);
        for(int i:nums)
        {
            System.out.print(i+" ");
        }
        int max = Integer.MIN_VALUE;
        for(int i =0; i<nums.length/2; i++)
        {
            max = Math.max(max,nums[i]+nums[nums.length-1-i]);
        }
        return max;

    }
}
