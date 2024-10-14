package main.java.com.kadaneAndBS;

public class C_LowerBound {

    public static int returnLowerBoundIndex(int []arr, int lengthOfArray, int x)
    {
        int low =0;
        int high = lengthOfArray -1;
        int mid;
        int lb = lengthOfArray;
        while(low<=high) {
            mid = (low+high)/2;
            if (arr[mid] >= x) {
                lb = mid;
                high = mid - 1;
            }
            else if (arr[mid] < x) {
                low = mid + 1;
            }
        }
        return lb;
    }
    public static void main(String [] args)
    {
        int[] arr = {1, 4, 7, 8, 10};
        System.out.println(returnLowerBoundIndex(arr, 4,5));
    }
}
