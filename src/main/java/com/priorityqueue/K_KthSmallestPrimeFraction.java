package main.java.com.priorityqueue;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class K_KthSmallestPrimeFraction {

    /**
     * <a href="https://leetcode.com/problems/k-th-smallest-prime-fraction/description/?envType=problem-list-v2&envId=heap-priority-queue">786. K-th Smallest Prime Fraction</a>
     */
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        Map<Float, int[]> map = new HashMap<>();
        PriorityQueue<Float> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                float frac = (float) arr[i] / (float) arr[j];
                if (k > 0) {
                    pq.add(frac);
                    k--;
                } else if (pq.peek() > frac) {
                    pq.poll();
                    pq.add(frac);
                }
                map.put(frac, new int[]{arr[i], arr[j]});
            }
        }
        return map.get(pq.peek());
    }
}
