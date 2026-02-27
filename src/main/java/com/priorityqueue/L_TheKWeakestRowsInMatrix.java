package main.java.com.priorityqueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class L_TheKWeakestRowsInMatrix {

    /**
     * <a href="https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/description/?envType=problem-list-v2&envId=heap-priority-queue">1337. The K Weakest Rows in a Matrix</a>
     */
    public int[] kWeakestRows(int[][] mat, int k) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int rowIndex = 0;
        for (int[] arr : mat) {
            int strength = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 1) {
                    strength++;
                } else {
                    break;
                }

            }
            if (map.containsKey(strength)) {
                map.get(strength).add(rowIndex);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(rowIndex);
                map.put(strength, l);
            }
            rowIndex++;
        }
        System.out.println(map.keySet());
        pq.addAll(map.keySet());
        int[] ans = new int[k];
        int count = 0;
        while (count < k) {
            List<Integer> l = map.get(pq.poll());
            for (int num : l) {
                if (count < k) {
                    ans[count] = num;
                    count++;
                } else {
                    break;
                }
            }
        }
        return ans;
    }
}
