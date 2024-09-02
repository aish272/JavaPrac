package main.java.com.kadaneAndBS;

public class D_UpperBound {

    public static int returnUpperBoundIndex(int []arr, int size, int target)
    {
        int low =0;
        int high = size -1;
        int mid;
        int lb = size;
        while(low<=high) {
            mid = (low+high)/2;
            if (arr[mid] > target) {
                lb = mid;
                high = mid - 1;
            }
            else  {
                low = mid + 1;
            }
        }
        return lb;
    }
    public static void main(String [] args)
    {
        int[] arr = {1, 4, 7, 8, 10};
        System.out.println(returnUpperBoundIndex(arr, 5,7));
    }
}
