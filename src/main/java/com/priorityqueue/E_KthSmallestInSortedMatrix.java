package main.java.com.priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class E_KthSmallestInSortedMatrix {

    /**
     * <a href="https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/">378. Kth Smallest Element in a Sorted Matrix</a>
     */
    public static int kthSmallest(int[][] matrix, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = matrix[i][j];
                if (pq.size() < k) {
                    pq.add(num);
                } else if (pq.peek() >= num) {
                    pq.poll();
                    pq.add(num);
                }
            }
        }
        return pq.peek();

    }

    public static void main(String[] args) {

        System.out.println(kthSmallest(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 8));
    }
}
