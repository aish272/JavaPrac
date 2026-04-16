package main.java.com.dp2;

import java.util.Arrays;

public class B_MaxProfitInJobScheduling {

    /**
     * <a href="https://leetcode.com/problems/maximum-profit-in-job-scheduling/">1235. Maximum Profit in Job Scheduling</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=LL0tVxlAeV4&list=PLpIkg8OmuX-L_QqcKB5abYynQbonaNcq3&index=5">Video solution link</a>
     */
    int n;

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        n = startTime.length;
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = startTime[i];
            arr[i][1] = endTime[i];
            arr[i][2] = profit[i];
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        return returnMaxProfit(arr, 0);

    }

    public int returnMaxProfit(int[][] arr, int index) {
        if (index >= n) return 0;

        int next = getNextJobIndex(arr, index + 1, arr[index][1]);
        int take = arr[index][2] + returnMaxProfit(arr, next);
        int notTake = returnMaxProfit(arr, index + 1);
        return Math.max(take, notTake);

    }

    public int getNextJobIndex(int[][] arr, int left, int currentJobEndTime) {
        int right = n - 1;
        int ans = n + 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid][0] >= currentJobEndTime) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public int jobSchedulingDp(int[] startTime, int[] endTime, int[] profit) {
        n = startTime.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = startTime[i];
            arr[i][1] = endTime[i];
            arr[i][2] = profit[i];
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        return returnMaxProfit(arr, 0, dp);

    }

    public int returnMaxProfit(int[][] arr, int index, int[] dp) {
        if (index >= n) return 0;
        if (dp[index] != -1) return dp[index];
        int next = getNextJobIndex(arr, index + 1, arr[index][1]);
        int take = arr[index][2] + returnMaxProfit(arr, next, dp);
        int notTake = returnMaxProfit(arr, index + 1, dp);
        return dp[index] = Math.max(take, notTake);

    }

}
