package main.java.com.arrays1;

import java.util.HashMap;

public class L_NumberOfSubArraysWithSumK {


    public static int numOfSubArraysWithSumK(int[] arr, int k) {

        int sum = 0;
        int subArrayLength = 0;
        int numOfSubArrays = 0;
        HashMap<Integer, Integer> preFixSum = new HashMap<>();
        for (int counter = 0; counter < arr.length; counter++) {
            sum += arr[counter];

            if (sum == k) {
                subArrayLength = counter + 1;
                numOfSubArrays++;
                if (arr[counter] == k && arr.length == 1) {
                    numOfSubArrays++;
                }
            } else if (preFixSum.containsKey(sum - k)) {
                subArrayLength = Math.max(subArrayLength, counter - preFixSum.get(sum - k));
                numOfSubArrays++;

            }
            if (!preFixSum.containsKey(sum)) {
                preFixSum.put(sum, counter);  // no need to put sum which already exists
            }

        }
        return numOfSubArrays;

    }

    public static int numOfSubArrayWithSumKBruteForce(int[] arr, int k) {

        int sum;
        int numOfSubArrays = 0;
        for (int counter = 0; counter < arr.length; counter++) {
            sum = 0;
            for (int innerCounter = counter; innerCounter < arr.length; innerCounter++) {

                sum += arr[innerCounter];
                if (sum == k) {
                    numOfSubArrays++;
                }

            }
        }
        return numOfSubArrays;
    }

    public static void main(String[] args) {
        System.out.println(numOfSubArraysWithSumK(new int[]{85, 16, 13, 37, 85, 16, 13, 37}, 122));
    }
}
