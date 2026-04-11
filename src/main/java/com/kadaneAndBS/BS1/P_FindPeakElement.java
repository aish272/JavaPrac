package main.java.com.kadaneAndBS.BS1;

public class P_FindPeakElement {

    /**
     * <a href="https://leetcode.com/problems/find-peak-element">162. Find Peak Element</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=cXxmbemS6XM&t=2s">BS-9. Find Peak Element</a>
     */

    public int findPeakElement(int[] nums) {

        if (nums.length == 1 || nums[0] > nums[1]) //first element is peak
            return 0;

        if (nums[nums.length - 2] < nums[nums.length - 1]) //last element is peak
            return nums.length - 1;

        int high = nums.length - 2;
        int low = 1;
        while (high >= low) {
            int mid = (high + low) / 2;
            if ((nums[mid - 1] < nums[mid]) && (nums[mid] > nums[mid + 1]))
                return mid;

            else if (nums[mid - 1] > nums[mid]) {
                high = mid - 1;
            }

            else {
                low = mid + 1;
            }

        }
        return -1;
    }
}
