package main.java.com.arrays1;
import  main.java.com.commonUtilities.A_MergeSort;

public class H_FindMissingNumber {


    public static int missingNumber(int[] nums) {
        new A_MergeSort().mergeSortAnArray(nums);
//        for (int num: nums)
//        {
//            System.out.println(num);
//        }
        if(nums[nums.length-1]==nums.length) {
            for (int counter = 0; counter < nums.length - 1; counter++) {
                if (nums[counter] + 1 != nums[counter + 1]) {
                    return nums[counter] + 1;
                }
            }
        }
        else
        {
            return nums.length;
        }
        return 0;
    }



    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{3,0,1}));
    }

}
