package main.java.com.kadaneAndBS.BS1;

public class G_SearchInRotatedArray {

    /**
     * <a href="https://leetcode.com/problems/search-in-rotated-sorted-array/description/">33. Search in Rotated Sorted Array</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=5qGrJbHhqFs&list=PLgUwDviBIf0pMFMWuuvDNMAkoQFi-h0ZF&index=5">Video solution link</a>
     */
    public static int searchInRotatedArray(int[] nums, int x) {

        int n = nums.length;
        int low =0;
        int high = n-1;
        int mid;
        while(low<=high) {
            mid = (low+high)/2;
            if(nums[mid]==x)
            {
                return mid;
            }
            //check if left is sorted else right will be definitely sorted as there is only one pivot point
            if(nums[low]<=nums[mid])
            {
              if(nums[low]<=x && x<nums[mid]) //check if element exists in the sorted left half range
              {
                  high = mid-1;
              }
              else {
                  low = mid +1;  // move to right half
              }
            }
            else
            {
                if(nums[mid]<x && x<=nums[high]) //check if element exists in the sorted right half range
                {
                    low = mid +1;
                }
                else {
                    high = mid-1; // move to left half
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {8,9,0,1,2,3,4,5,6,7};
        System.out.println(searchInRotatedArray(arr, 1));
    }
}
