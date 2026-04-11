package main.java.com.greedyAlgo;

import java.util.Arrays;

public class F_MaxBagsWithFullCapacityOfRocks {

    /**
     * <a href="https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks/description/">2279. Maximum Bags With Full Capacity of Rocks</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=JpQaui_-a4c&list=PLpIkg8OmuX-J8_n8Vy9P9I3KvyDcPMzRU&index=9">Video solution link</a>
     */
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {

        int[] required = new int[capacity.length];
        for (int i = 0; i < capacity.length; i++) {
            required[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(required);
        int index = 0;
        while (index < capacity.length && additionalRocks > 0) {
            if (additionalRocks >= required[index]) {
                additionalRocks -= required[index];
                required[index] = 0;

            }
            index++;
        }
        int count = 0;
        for (int num : required) {
            if (num == 0) {
                count++;
            }
        }
        return count;

    }
}
