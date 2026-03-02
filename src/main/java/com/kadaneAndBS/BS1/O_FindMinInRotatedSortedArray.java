package main.java.com.kadaneAndBS.BS1;

public class O_FindMinInRotatedSortedArray {

    /**
     * <a href="https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/">34. Find First and Last Position of Element in Sorted Array</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=nhEMDKMB44g&list=PLgUwDviBIf0pMFMWuuvDNMAkoQFi-h0ZF&index=7">Video solution link</a>
     */
    public int findMin(int[] nums) {

        int low = 0;
        int high = nums.length-1;
        int ans = Integer.MAX_VALUE;
        while(low<=high){
            int mid = (low+high)/2;

            if(nums[low]<=nums[mid])
            {
                ans = Math.min(ans, nums[low]);
                low = mid+1; // go to unsorted right half

            }
            else
            {
                ans = Math.min(ans, nums[mid]);
                high = mid - 1; // go to unsorted left half
            }
        }
        return ans;

    }
}
