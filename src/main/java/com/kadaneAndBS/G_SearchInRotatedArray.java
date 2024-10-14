package main.java.com.kadaneAndBS;

public class G_SearchInRotatedArray {

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
            if(nums[low]<=nums[mid])
            {
              if(nums[low]<=x && x<nums[mid])
              {
                  high = mid-1;
              }
              else {
                  low = mid +1;
              }
            }
            else
            {
                if(nums[mid]<x && x<=nums[n-1])
                {
                    low = mid +1;
                }
                else {
                    high = mid-1;
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {9,18,66,1,4,5};
        System.out.println(searchInRotatedArray(arr, 18));
    }
}
