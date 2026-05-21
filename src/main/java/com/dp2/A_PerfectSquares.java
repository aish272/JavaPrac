package main.java.com.dp2;

import java.util.Arrays;

public class A_PerfectSquares {

    /**
     * <a href="https://leetcode.com/problems/perfect-squares/description/">279. Perfect Squares</a>
     */
    //my solution
    public static int numSquares(int n) {
        return getNumSquares(n, 1, 0);
    }

    public static int getNumSquares(int n, int num, int totalNums) {

        if (n < 0) return Integer.MAX_VALUE;
        if (n == 0) return totalNums;
        if (num * num > n) return Integer.MAX_VALUE;
        int pick = getNumSquares(n - (num * num), num, totalNums + 1);
        int notPick = getNumSquares(n, num + 1, totalNums);
        return Math.min(pick, notPick);
    }

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }

    /**
     * <a href="https://www.youtube.com/watch?v=Zbn8in7hpXY&list=PLpIkg8OmuX-L_QqcKB5abYynQbonaNcq3&index=4">Video solution link</a>
     */

    public int numSquaresDp(int n) {
        int[] dp = new int[n + 1];

        Arrays.fill(dp, -1);

        return getNumSquares(n, dp);
    }

    public int getNumSquares(int n, int[] dp) {
        if (n == 0) return 0;

        if (dp[n] != -1) return dp[n];
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            int current = 1 + getNumSquares(n - (i * i), dp);
            ans = Math.min(ans, current);
        }
        return dp[n] = ans;

    }
}
