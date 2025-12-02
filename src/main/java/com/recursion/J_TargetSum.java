package main.java.com.recursion;

public class J_TargetSum {

    /**
     * <a href="https://leetcode.com/problems/target-sum/">494. Target Sum</a>
     */
    public int findTargetSumWays(int[] nums, int target) {
        return returnTotalTargetSumWays(nums, target, 0, 0);
    }

    public int returnTotalTargetSumWays(int[] nums, int target, int index, int total) {

        if (index == nums.length) {

            return (total == target) ? 1 : 0;
        }
        int plus = returnTotalTargetSumWays(nums,target,index+1,total+nums[index]);
        int minus = returnTotalTargetSumWays(nums,target,index+1,total-nums[index]);

        return (plus+minus);

    }
}
