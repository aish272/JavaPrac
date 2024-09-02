package main.java.com.kadaneAndBS;

public class F_FloorAndCeil {

    public static int[] floorAndCeil(int[] a, int n, int x) {

        int low =0;
        int high = n-1;
        int mid;
        int ceil = -1;
        int floor =-1;
        int[] arr = new int[2];
        while(low<=high) {
            mid = (low+high)/2;
            if (a[mid] >= x) {
                ceil = a[mid];
                high = mid - 1;
            }
            else if (a[mid] < x) {
                low = mid + 1;
            }
        }
         low =0;
         high = n-1;
        while(low<=high) {
            mid = (low+high)/2;
            if (a[mid] <= x) {
                floor = a[mid];
                low = mid + 1;
            }
            else if (a[mid] > x) {
                high = mid - 1;
            }
        }
        arr[0] = floor;
        arr[1] = ceil;
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,6,7};
        System.out.println((floorAndCeil(arr, 5, 3))[0]);
        System.out.println((floorAndCeil(arr, 5, 3))[1]);
    }
}
