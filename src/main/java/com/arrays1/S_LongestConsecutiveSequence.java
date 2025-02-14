package main.java.com.arrays1;

import java.util.Arrays;

public class S_LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {

        Arrays.sort(nums);
        int count = 0;
        int length = 1;
        for (int index = 0; index < nums.length - 1; index++) {
            if (nums[index] + 1 == nums[index + 1]) {
                if (count == 0) count += 2;
                else count++;
            }
            else if (nums[index]  == nums[index + 1])
            {
                continue;
            }
            else {
                count = 0;
            }
            length = Math.max(count, length);

        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }
}
