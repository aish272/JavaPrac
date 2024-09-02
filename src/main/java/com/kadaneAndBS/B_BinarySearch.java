package main.java.com.kadaneAndBS;

public class B_BinarySearch {

    public static int returnTargetIndexUsingBinSearch(int[] nums, int target)
    {
        int low = 0;
        int high = nums.length-1;
        return divideTheArray(nums,target,low,high);
    }

    public static int divideTheArray(int[] nums, int target, int low, int high)
    {
        int mid = (low+high)/2;
        if(high<low)
        {
            return -1;
        }
        if(nums[mid] == target)
        {
            return mid;
        }
        else if(nums[mid]>target)
        {
            return divideTheArray(nums,target,low,mid-1);
        }
        else {
            return divideTheArray(nums, target, mid + 1, high);
        }
    }

    public static void main(String [] args)
    {
        int[] arr = {-1,0,3,5,9,12};
        System.out.println(returnTargetIndexUsingBinSearch(arr,3));

    }
}
