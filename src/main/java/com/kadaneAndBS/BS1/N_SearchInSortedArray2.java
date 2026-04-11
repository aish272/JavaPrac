package main.java.com.kadaneAndBS.BS1;

public class N_SearchInSortedArray2 {

    /**
     * <a href="https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/">81. Search in Rotated Sorted Array II</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=w2G2W8l__pc&list=PLgUwDviBIf0pMFMWuuvDNMAkoQFi-h0ZF&index=6">Video solution link</a>
     */

    public static boolean search(int[] nums, int target) {

        int low = 0;
        int high = nums.length-1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[low] == nums[mid] && nums[high] == nums[mid]) {
                low = low + 1;
                high = high - 1;
                continue;
            }
            if (nums[mid] == target)
                return true;
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;

    }

    public static void main(String[] args)
    {
        System.out.println(search(new int[]{1,0,1,1,1},0));
    }
}
