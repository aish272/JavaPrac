package main.java.com.kadaneAndBS;

public class Y_PeakIndexInMountainArray {

    /**
     * <a href="https://leetcode.com/problems/peak-index-in-a-mountain-array/">852. Peak Index in a Mountain Array</a>
     */
    public int peakIndexInMountainArray(int[] arr) {

        int low = 1;
        int high = arr.length - 2;
        while (high >= low) {
            int mid = (low + high) / 2;
            int num = arr[mid];
            int prev = arr[mid - 1];
            int next = arr[mid + 1];
            if (num > prev && num > next) {
                return mid;
            } else if (prev > num && num > next) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return -1;

    }
}
