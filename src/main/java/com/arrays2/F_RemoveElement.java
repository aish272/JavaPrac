package main.java.com.arrays2;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/remove-element/description/">27. Remove Element</a>
 */
public class F_RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int wait = 0;
        for (int traverse = 0; traverse < nums.length; traverse++) {
            if (nums[traverse] != val) {
                nums[wait] = nums[traverse];
                wait++;

            }

        }
        return wait;

    }
    public static void main(String[] args)
    {
        int[]arr = new int[]{1,0,2,0,3,0,4,0,5,0};
        System.out.println(removeElement(arr,0));
        System.out.println(Arrays.toString(arr));

    }
}
