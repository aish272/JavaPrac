package main.java.com.greedyAlgo;

import java.util.HashSet;
import java.util.Set;

public class I_MaxNumOfIntsToChooseFromRange {

    /**
     * <a href="https://leetcode.com/problems/maximum-number-of-integers-to-choose-from-a-range-i/description/">2554. Maximum Number of Integers to Choose From a Range I</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=urduKO4oFlo">Video solution link</a>
     */
    public int maxCount(int[] banned, int n, int maxSum) {

        Set<Integer> s = new HashSet<>();
        for (int num : banned) {
            s.add(num);
        }
        int sum = 0;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (sum + i <= maxSum && !s.contains(i)) {
                sum += i;
                count++;
            } else if (sum > maxSum) {
                break;
            }
        }
        return count;

    }
}
