package main.java.com.greedyAlgo;

import java.util.Arrays;

public class O_MaxEleAfterDecreasingAndRearranging {

    /**
     * <a href="https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging/">1846. Maximum Element After Decreasing and Rearranging</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=HGkK9n5CUaY&list=PLpIkg8OmuX-J8_n8Vy9P9I3KvyDcPMzRU&index=22">Video solution link</a>
     */
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        if (arr[0] != 1) {

            arr[0] = 1;
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i] - arr[i - 1]) > 1) {
                arr[i] = arr[i - 1] + 1;
            }
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
