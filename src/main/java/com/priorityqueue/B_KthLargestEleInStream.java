package main.java.com.priorityqueue;


import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/kth-largest-element-in-a-stream/description/">703. Kth Largest Element in a Stream</a>
 * <br/>
 */
class KthLargest {
    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<Integer>();
        for (int i = 0; i < k && i < nums.length; i++) {
            pq.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > pq.peek()) {
                pq.poll();
                pq.add(nums[i]);
            }
        }

    }

    public int add(int val) {

        if (pq.isEmpty() || k > pq.size()) {
            pq.add(val);
            return pq.peek();
        }

        if (val > pq.peek() && k == pq.size()) {

            pq.poll();
            pq.add(val);

        }
        return pq.peek();

    }
}

public class B_KthLargestEleInStream {

}
