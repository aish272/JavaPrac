package main.java.com.kadaneAndBS;

public class K_FirstAndLastPosOfEleInSortedArr {

    /**
     * <a href="https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/">34. Find First and Last Position of Element in Sorted Array</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=hjR1IYVx9lY&list=PLgUwDviBIf0pMFMWuuvDNMAkoQFi-h0ZF&index=4">Video solution link</a>
     */

    //solved using upper and lower bound
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int low = 0;
        int high = nums.length - 1;
        int start = -1;
        int end = nums.length;
        //Using lower bound to find the starting index
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= target) {

                if (nums[mid] == target) {
                    start = mid;
                }
                high = mid - 1; //try finding smaller index with value greater than target
            } else {
                low = mid + 1; //try to find greater value
            }
        }
        low = 0;
        high = nums.length - 1;
        if (start != -1) { //find end index only if the element exists
            //Using upper bound to find the end index
            while (low <= high) {
                int mid = (low + high) / 2;
                if (nums[mid] > target) {

                    if (nums[mid] > target) {
                        end = mid;
                    }
                    high = mid - 1; //try finding smaller index with value greater than target
                } else {
                    low = mid + 1; //try to find greater value
                }
            }
        } else {
            return new int[]{-1, -1};
        }
        return new int[]{start, end - 1};

    }

    //solved using simple binary search
    public int firstOccurrence(int[] nums, int target)
    {
        int low =0;
        int high = nums.length-1;
        int start = -1;
        while(high>=low)
        {
            int mid = (low+high)/2;
            if(nums[mid]==target)
            {
                start = mid;
                high = mid-1;
            } else if (nums[mid]<target) {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return start;
    }

    public int findLastOccurrence(int[] nums, int target)
    {
        int low =0;
        int high = nums.length-1;
        int end = -1;
        while (high>=low)
        {
            int mid = (high+low)/2;
            if(nums[mid]==target)
            {
                end = mid;
                low = mid+1;
            }
            else if(nums[mid]<target)
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return end;
    }
    public int[] searchRangeUsingSimpleBinarySearch(int[] nums, int target) {
        int start  = firstOccurrence(nums,target);
        if(start==-1)
            return new int[] {-1,-1};
        return new int[] {start,findLastOccurrence(nums,target)};
    }
}

