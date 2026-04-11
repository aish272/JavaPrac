package main.java.com.priorityqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class C_TopKFreqElement {

    /**
     * <a href="https://leetcode.com/problems/top-k-frequent-elements/">347. Top K Frequent Elements</a>
     */
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : nums) {

            map.put(i, map.getOrDefault(i, 0) + 1);

        }
        int[] ans = new int[k];
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (Map.Entry<Integer, Integer> ele : map.entrySet()) {
            if (pq.size() < k) {
                pq.add(ele.getValue());
            } else {
                if (pq.peek() < ele.getValue()) {
                    pq.poll();
                    pq.add(ele.getValue());

                }
            }
        }
        int index = 0;
        for (Map.Entry<Integer, Integer> ele : map.entrySet()) {
            if (pq.contains(ele.getValue())) {
                ans[index] = ele.getKey();
                index++;
            }
        }
        return ans;

    }
}
