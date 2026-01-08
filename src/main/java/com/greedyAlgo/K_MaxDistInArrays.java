package main.java.com.greedyAlgo;

import java.util.List;

public class K_MaxDistInArrays {

    /**
     * <a href="https://leetcode.com/problems/maximum-distance-in-arrays/">624. Maximum Distance in Arrays</a>
     */
    public int maxDistance(List<List<Integer>> arrays) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minInd = 0;
        int maxInd = 0;
        int min1 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        for (int i = 0; i < arrays.size(); i++) {
            List<Integer> l = arrays.get(i);
            int last = l.get(l.size() - 1);
            if (max < last) {
                max1 = max;
                max = last;
                maxInd = i;

            } else if (max1 < last) {
                max1 = last;
            }
            int first = l.get(0);
            if (min > first) {
                min1 = min;
                min = first;
                minInd = i;
            } else if (min1 > first) {
                min1 = first;
            }
        }
        if (minInd == maxInd) {
            return Math.max(Math.abs(max - min1), Math.abs(max1 - min));
        }
        return Math.abs(max - min);

    }
}
