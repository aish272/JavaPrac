package main.java.com.priorityqueue;

import java.util.PriorityQueue;

public class A_KthLargestElement {

    /**
     * <a href="https://leetcode.com/problems/kth-largest-element-in-an-array/description/">215. Kth Largest Element in an Array</a>
     * <br/>
     * <a href="https://takeuforward.org/plus/dsa/problems/k-th-largest-element-in-an-array?category=heaps&subcategory=theory-and-implementation&tab=editorial">Video solution link</a>
     */
    public static int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > pq.peek()) {
                pq.poll();
                pq.add(nums[i]);
            }
        }
        return pq.peek();

    }

    public static void main(String[] args) {
        findKthLargest(new int[]{2,5,7,3,8,5,22,90}, 3);
    }

}
