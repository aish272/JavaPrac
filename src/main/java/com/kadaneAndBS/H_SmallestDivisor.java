package main.java.com.kadaneAndBS;

public class H_SmallestDivisor {

    public static int smallestDivisor(int[] nums, int threshold) {

        int max = nums[0];
        int smallestDiv = 0;
        //high will store the max value from the array
        for (int i = 1; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        int[] divisors = new int[max];
        for (int i = 1; i <= max; i++) {
            divisors[i - 1] = i;
        }
        int low = 0;
        int high = divisors.length;

        int mid = 0;
        while (high >= low) {
            int sum = 0;
            mid = (high + low) / 2;

            for (int num : nums) {
                sum += Math.ceilDiv(num, divisors[mid]);
            }
             if (sum <= threshold) {
                high = mid - 1;
                smallestDiv = divisors[mid];
            } else {
                low = mid + 1;
            }
        }

        return smallestDiv;
    }
    public static void main(String[] args)
    {
        System.out.println(smallestDivisor(new int[]{1000000},2));
    }
}
