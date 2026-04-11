package main.java.com.arrays2;

import java.util.Arrays;

public class N_UniqueNumOfOccurrences {

    /**
     * <a href="https://leetcode.com/problems/unique-number-of-occurrences/">1207. Unique Number of Occurrences</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=b2_rw2NZkr8&list=PLpIkg8OmuX-JVSpdssgeSsB5srSoNn55o&index=3">Video solution link</a>
     */
    public boolean uniqueOccurrences(int[] arr) {

        int[] freq = new int[2001]; //to include all -1000 <= arr[i] <= 1000
        for (int n : arr) {
            n = n + 1000; //to make it positive
            freq[n] += 1;
        }
        Arrays.sort(freq);
        int index = 2000;
        while (freq[index - 1] > 0) {
            if (freq[index] == freq[index - 1]) {
                return false;
            }
            index--;
        }
        return true;

    }
}
