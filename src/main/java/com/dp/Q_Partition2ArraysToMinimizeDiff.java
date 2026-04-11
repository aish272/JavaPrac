package main.java.com.dp;

public class Q_Partition2ArraysToMinimizeDiff {

    public static int canPartition(int[] nums) {
        int notAddedSum = 0;
        for (int num : nums)
            notAddedSum += num;
        return isPartitionSumPossible(0, nums, 0, notAddedSum);
    }

    public static int isPartitionSumPossible(int index, int[] candidateArr, int sum, int notAddedSum) {
        if (index==candidateArr.length-1) {
            return Math.abs(sum - notAddedSum);
        }
        sum += candidateArr[index];
        notAddedSum -= candidateArr[index];
        int take = isPartitionSumPossible(index + 1, candidateArr, sum, notAddedSum);
        sum -= candidateArr[index];
        notAddedSum += candidateArr[index];
        int notTake = isPartitionSumPossible(index + 1, candidateArr, sum, notAddedSum);
        return Math.min(take ,notTake);
    }

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{-36,36}));
    }
}
