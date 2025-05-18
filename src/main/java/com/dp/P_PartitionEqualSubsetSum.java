package main.java.com.dp;

import java.util.Arrays;

public class P_PartitionEqualSubsetSum {

    public static boolean canPartition(int[] nums) {
        int notAddedSum = 0;
        for (int num : nums)
            notAddedSum += num;
        return isPartitionSumPossible(0, nums, 0, notAddedSum);
    }

    public static boolean isPartitionSumPossible(int index, int[] candidateArr, int sum, int notAddedSum) {
        if (sum == notAddedSum && index != 0) {
            return true;
        } else if (index == candidateArr.length) {
            return false;
        }
        sum += candidateArr[index];
        notAddedSum -= candidateArr[index];
        boolean take = isPartitionSumPossible(index + 1, candidateArr, sum, notAddedSum);
        sum -= candidateArr[index];
        notAddedSum += candidateArr[index];
        boolean notTake = isPartitionSumPossible(index + 1, candidateArr, sum, notAddedSum);
        return take | notTake;
    }

    public static boolean canPartitionDp(int[] nums) {
        int notAddedSum = 0;
        for (int num : nums) notAddedSum += num;
        int[][] dp = new int[nums.length][notAddedSum + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return isPartitionSumPossibleDp(0, nums, 0, notAddedSum, dp);
    }

    public static boolean isPartitionSumPossibleDp(int index, int[] candidateArr, int sum, int notAddedSum, int[][] dp) {
        if (sum == notAddedSum && index != 0) {
            dp[index][sum] = 1;
            return true;
        } else if (index == candidateArr.length) {
            return false;
        } else if (index == candidateArr.length - 1 && sum != notAddedSum) {
            return false;
        }
        if (dp[index][sum] != -1) return dp[index][sum] == 1;

        sum += candidateArr[index];
        notAddedSum -= candidateArr[index];
        boolean take = isPartitionSumPossibleDp(index + 1, candidateArr, sum, notAddedSum, dp);
        sum -= candidateArr[index];
        notAddedSum += candidateArr[index];
        boolean notTake = isPartitionSumPossibleDp(index + 1, candidateArr, sum, notAddedSum, dp);
        dp[index][sum] = notTake || take ? 1 : 0;
        return take | notTake;
    }


    public static void main(String[] args) {
        System.out.println(canPartitionDp(new int[]{100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 99, 97}));
    }
}
