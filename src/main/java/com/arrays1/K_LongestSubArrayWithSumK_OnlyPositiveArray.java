package main.java.com.arrays1;

public class K_LongestSubArrayWithSumK_OnlyPositiveArray {


    public static int longestSubArrayWithSumK_ForOnlyPostvArr(int[] a, long k) {
        int sum = 0;
        int right = 0;
        int left = 0;
        int maxSubArrayLength = 0;
        while (right < a.length) {
            sum += a[right];
            while (sum > k && left <= right) {
                sum = sum - a[left];
                left++;
            }
            if (sum == k) {
                maxSubArrayLength = Math.max(maxSubArrayLength, (right - left) + 1);
            }
            right++;
        }
        return maxSubArrayLength;
    }

    public static void main(String[] args) {
        System.out.println(longestSubArrayWithSumK_ForOnlyPostvArr(new int[]{1, 2, 1, 3}, 2));
    }
}
