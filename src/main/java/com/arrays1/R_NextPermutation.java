package main.java.com.arrays1;

import java.util.Arrays;

public class R_NextPermutation {

    public static int[] nextPermutation(int[] nums) {

        int len = nums.length;
        int breakpoint = -1;
        for(int index=len-1;index>0;index--)
        {
            if(nums[index-1]<nums[index])
            {
                breakpoint = index-1;
                break;
            }
        }if(breakpoint!=-1) {
            for (int index = len - 1; index > breakpoint; index--) {
                if (nums[index] > nums[breakpoint]) {
                    reverseInArray(nums, breakpoint, index);
                    break;
                }
            }
            for (int index = 0; index < (len - breakpoint) / 2; index++) {
                reverseInArray(nums, index + breakpoint + 1, len - index - 1);
            }
        }
        else
        {
            for(int index=0;index<=len/2;index++)
            {
                reverseInArray(nums,index,len-index-1);
            }
        }
        return nums;
    }

    public static void reverseInArray(int[] array, int index1, int index2)
    {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextPermutation(new int[]{3,2,1})));
    }
}
