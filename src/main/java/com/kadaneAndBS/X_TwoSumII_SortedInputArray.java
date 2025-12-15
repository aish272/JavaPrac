package main.java.com.kadaneAndBS;

public class X_TwoSumII_SortedInputArray {

    /**
     * <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/">167. Two Sum II - Input Array Is Sorted</a>
     */

    public int[] twoSum(int[] numbers, int target) {

        for (int i = 0; i < numbers.length; i++) {
            int secondNum;
            if (numbers[i] >= 0) {
                secondNum = target - numbers[i];
            } else {
                if (target == 0) {
                    secondNum = -numbers[i];
                } else if (target < 0) {
                    secondNum = target + (-numbers[i]);
                } else {
                    secondNum = target + numbers[i];
                }
            }
            int index = returnIndex(secondNum, numbers, i);
            if (index != -1 && numbers[i] + numbers[index - 1] == target) {
                if (index < i + 1) {
                    return new int[] { index, i + 1 };
                } else {

                    return new int[] { i + 1, index };
                }
            }

        }
        return new int[] { -1, -1 };

    }

    public int returnIndex(int target, int[] numbers, int firstInd) {
        int low = 0;
        int high = numbers.length - 1;
        while (high >= low) {
            int mid = (high + low) / 2;
            if (numbers[mid] == target && firstInd != mid) {
                return mid + 1;
            } else if (numbers[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
