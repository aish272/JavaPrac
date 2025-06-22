package main.java.com.kadaneAndBS;

public class I_SingleEleInSortedArray {

    /**
     * <a href="https://leetcode.com/problems/single-element-in-a-sorted-array/description/">540. Single Element in a Sorted Array</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=PzszoiY5XMQ&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=65">Video link</a>
     */
    public static int singleNonDuplicate(int[] nums) {
        if(nums.length==1)
            return nums[0];
        if(nums[0]!=nums[1])
            return nums[0];
        if(nums[nums.length-1]!=nums[nums.length-2])
            return nums[nums.length-1];
        int start =1;
        int end = nums.length-2;
        while(start<=end)
        {
            int mid = (start+end)/2;
            if(nums[mid]!=nums[mid-1] &&nums[mid]!=nums[mid+1])
                return nums[mid];
            if((mid%2==0&&nums[mid]==nums[mid+1]) ||(mid%2==1&&nums[mid]==nums[mid-1]))
            {
                start = mid+1;
            }
            else
            {
                end = mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args)
    {
        System.out.println(singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));
    }

}
