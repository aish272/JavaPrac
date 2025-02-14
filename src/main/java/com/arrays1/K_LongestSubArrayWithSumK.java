package main.java.com.arrays1;

import java.util.HashMap;

public class K_LongestSubArrayWithSumK {


    public static int longestSubArrayWithSumK(int[] arr, int k) {

        int sumEqualToK = 0;
        int subArrayLength = 0;
        HashMap<Integer, Integer> preFixSum = new HashMap<>();
        for (int counter = 0; counter < arr.length; counter++) {
            sumEqualToK += arr[counter];

            if (sumEqualToK == k) {
                subArrayLength = counter + 1;
            } else if (preFixSum.containsKey(sumEqualToK - k)) {
                subArrayLength = Math.max(subArrayLength, counter - preFixSum.get(sumEqualToK - k));

            }
            if (!preFixSum.containsKey(sumEqualToK)) {
                preFixSum.put(sumEqualToK, counter);  // no need to put sum which already exists
            }

        }
        return subArrayLength;

    }

    public static void main(String[] args) {
        System.out.println(longestSubArrayWithSumK(new int[]{85, 16, 13, 37, 85, 16, 13, 37}, 122));
    }
}
