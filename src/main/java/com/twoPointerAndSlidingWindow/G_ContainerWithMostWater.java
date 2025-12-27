package main.java.com.twoPointerAndSlidingWindow;

public class G_ContainerWithMostWater {


    /**
     * <a href="https://leetcode.com/problems/container-with-most-water/">11. Container With Most Water</a>
     */


    public int maxArea(int[] height) {
        int left = 0;
        int capacity = Integer.MIN_VALUE;
        for (; left < height.length - 1; left++) {
            for (int right = height.length - 1; right > 0; right--) {
                int cap = (right - left) * (Math.min(height[right], height[left]));
                if (cap > capacity) {
                    capacity = cap;
                }
            }
        }
        return capacity;

    }

    public int maxAreaBetter(int[] height) {


        int left = 0;
        int capacity = Integer.MIN_VALUE;
        int right = height.length - 1;
        while (left < height.length - 1) {
            for (int r = right; r > left; r--) {
                int cap = (r - left) * (Math.min(height[r], height[left]));
                if (cap > capacity) {
                    capacity = cap;
                }
            }
            int temp = left;
            while (height[left] <= height[temp] && left < height.length - 1) {
                left++;
            }

        }
        return capacity;

    }
}
