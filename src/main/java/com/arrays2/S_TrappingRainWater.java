package main.java.com.arrays2;

public class S_TrappingRainWater {

    /**
     * <a href="https://leetcode.com/problems/trapping-rain-water/">42. Trapping Rain Water</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=f2QgmVxPiS4&list=PLpIkg8OmuX-K6A0sEPFxOSJh4_AjCGAFf&index=4">Video solution link</a>
     */
    public int trap(int[] height) {
        int n = height.length;
        int[] maxFromLeft = new int[n];
        int[] maxFromRight = new int[n];
        maxFromLeft[0] = height[0];
        maxFromRight[n - 1] = height[n - 1];

        for (int i = 1; i < n - 1; i++) {
            maxFromLeft[i] = Math.max(height[i], maxFromLeft[i - 1]);
            maxFromRight[n - i - 1] = Math.max(height[n - i - 1], maxFromRight[n - i]);

        }

        int waterUnits = 0;
        for (int i = 1; i < n - 1; i++) {
            waterUnits += Math.min(maxFromLeft[i], maxFromRight[i]) - height[i];
        }
        return waterUnits;

    }
}
