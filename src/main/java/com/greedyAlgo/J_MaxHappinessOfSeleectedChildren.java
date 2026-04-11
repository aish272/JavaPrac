package main.java.com.greedyAlgo;

import java.util.HashSet;
import java.util.Set;

public class J_MaxHappinessOfSeleectedChildren {

    /**
     * <a href="https://leetcode.com/problems/maximize-happiness-of-selected-children/description/">3075. Maximize Happiness of Selected Children</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=Gk6ZZskgFTg&list=PLpIkg8OmuX-J8_n8Vy9P9I3KvyDcPMzRU&index=32">Video solution link</a>
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
