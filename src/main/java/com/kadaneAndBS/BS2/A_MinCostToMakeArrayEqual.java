package main.java.com.kadaneAndBS.BS2;

public class A_MinCostToMakeArrayEqual {

    /**
     * <a href="https://leetcode.com/problems/minimum-cost-to-make-array-equal/">2448. Minimum Cost to Make Array Equal</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=lGo6E8jiDB8&t=147s">Solution Video</a>
     * <a href="https://www.youtube.com/watch?v=lGo6E8jiDB8&t=147s">GPT Solution</a>
     */
    public long minCost(int[] nums, int[] cost) {

        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;

        for (int num : nums) {
            left = Math.min(left, num);
            right = Math.max(right, num);
        }

        long ans = Long.MAX_VALUE;

        while (left < right) {
            int mid = left + (right - left) / 2;

            long cost1 = findCost(nums, cost, mid);
            long cost2 = findCost(nums, cost, mid + 1);

            ans = Math.min(cost1, cost2);

            if (cost1 > cost2) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (ans == Long.MAX_VALUE) return 0;
        return ans;

    }

    private long findCost(int[] nums, int[] cost, int target) {
        long total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += (long) Math.abs(nums[i] - target) * cost[i];
        }
        return total;
    }
}
