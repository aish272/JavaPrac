package main.java.com.bst;

import java.util.Arrays;

public class N_UniqueBSTs {

    /**
     * <a href="https://leetcode.com/problems/unique-binary-search-trees/description">96. Unique Binary Search Trees</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=SXU--MPoUe8&t=539s">Unique Binary Search Trees II | Similar Problem | Recursion | Memoization | Amazon | Leetcode-95
     * <br/>
     * I watched this to solve question No 96</a>
     */
    public static int numTrees(int n) {
        return returnNumOfBSTs(1, n);
    }

    public static int returnNumOfBSTs(int start, int end) {
        if (start > end)
            return 1;
        int totalNodes = 0;
        for (int i = start; i <= end; i++) {
            int leftNodes = returnNumOfBSTs(start, i - 1);
            int rightNodes = returnNumOfBSTs(i + 1, end);

            totalNodes += leftNodes * rightNodes;
        }
        return totalNodes;
    }
    //dp
    public int numTreesDp(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return returnNumOfBSTs(1, n, dp);
    }

    public int returnNumOfBSTs(int start, int end, int[][] dp) {
        if (start > end)
            return 1;
        if (dp[start][end] != -1)
            return dp[start][end];
        int totalNodes = 0;
        for (int i = start; i <= end; i++) {
            int leftNodes = returnNumOfBSTs(start, i - 1, dp);
            int rightNodes = returnNumOfBSTs(i + 1, end, dp);

            totalNodes += leftNodes * rightNodes;
        }
        return dp[start][end] = totalNodes;
    }

    public static void main(String[] args)
    {
        System.out.println(numTrees(3));
    }
}
