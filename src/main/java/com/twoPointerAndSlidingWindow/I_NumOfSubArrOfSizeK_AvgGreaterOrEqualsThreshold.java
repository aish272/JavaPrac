package main.java.com.twoPointerAndSlidingWindow;

public class I_NumOfSubArrOfSizeK_AvgGreaterOrEqualsThreshold {

    /**
     * <a href="https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold">1343. Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold</a>
     */
    public int numOfSubarrays(int[] arr, int k, int threshold) {

        int left = 0;
        int right = k-1;
        int ans = 0;
        while(right<arr.length)
        {
            int sum = 0;
            int count = 0;
            while(count<k)
            {
                sum += arr[left+count];
                count++;
            }
            if((sum/k)>=threshold)
            {
                ans ++;
            }
            left++;
            right++;
        }
        return ans;

    }

    public int numOfSubarraysBetter(int[] arr, int k, int threshold) {

        int left = 0;
        int right = k - 1;
        int ans = 0;
        int sum = 0;
        int count = 0;
        while (count < k) {
            sum += arr[left + count];
            count++;
        }
        while (right < arr.length) {
            if (left > 0) {
                sum -= arr[left - 1];
                sum += arr[right];
            }

            if ((sum / k) >= threshold) {
                ans++;
            }
            left++;
            right++;
        }
        return ans;

    }


}
