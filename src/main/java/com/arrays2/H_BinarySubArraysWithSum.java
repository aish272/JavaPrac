package main.java.com.arrays2;

public class H_BinarySubArraysWithSum {

    /**
     * <a href="https://leetcode.com/problems/binary-subarrays-with-sum/">930. Binary Subarrays With Sum</a>
     */
    public int numSubarraysWithSum(int[] nums, int goal) {
        int ans =0;
        for(int index=0;index<nums.length;index++)
        {
            int sum = 0;
            for(int innerIndex=index;innerIndex<nums.length;innerIndex++)
            {
                sum += nums[innerIndex];
                if(sum==goal)
                {
                    ans++;

                }
                else if(sum>goal)
                {
                    break;
                }
            }
        }
        return ans;

    }
}
