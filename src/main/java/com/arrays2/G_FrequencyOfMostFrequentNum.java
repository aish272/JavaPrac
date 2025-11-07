package main.java.com.arrays2;

import java.util.Arrays;

public class G_FrequencyOfMostFrequentNum {

    public static int maxFrequency(int[] nums, int k) {

        Arrays.sort(nums);
        int[] hash = new int[nums[nums.length - 1]+1];
        for (int index = 1; index < nums.length; index++) {
            hash[nums[index]]++;
        }
        int max = 1;
        for (int index = 1; index < nums.length; index++) {
            int tempK = 0;
            int tempMax = 0;
            while (tempK <= k) {
                if (nums[index] - tempK>=0) {
                    tempMax = tempMax + hash[nums[index] - tempK];
                }
                tempK++;
            }
            max = Math.max(max, tempMax);
        }
        return max;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2,4};
        System.out.println(maxFrequency(arr,5));
    }
}
