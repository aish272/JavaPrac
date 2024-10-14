package main.java.com.kadaneAndBS;

public class E_SearchInsertPosition {

    public static int searchInsert(int[] nums, int x) {

        int n = nums.length;
        int low =0;
        int high = n-1;
        int mid;
        int lb = n;
        while(low<=high) {
            mid = (low+high)/2;
            if (nums[mid] >= x) {
                lb = mid;
                high = mid - 1;
            }
            else if (nums[mid] < x) {
                low = mid + 1;
            }
        }
        return lb;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,6,7};
        System.out.println(searchInsert(arr, 3));
    }
}
