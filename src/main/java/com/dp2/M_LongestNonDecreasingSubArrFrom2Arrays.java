package main.java.com.dp2;

public class M_LongestNonDecreasingSubArrFrom2Arrays {

    /**
     * <a href="https://leetcode.com/problems/longest-non-decreasing-subarray-from-two-arrays/description/">2771. Longest Non-decreasing Subarray From Two Arrays</a>
     */
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {

        int prev1 = 1;
        int prev2 = 1;
        int ans = Integer.MIN_VALUE;

        for (int i = 1; i < nums1.length; i++) {
            int cur1 = 1;
            int cur2 = 1;

            if (nums1[i] >= nums1[i - 1]) {
                cur1 = Math.max(cur1, prev1 + 1);
            }

            if (nums1[i] >= nums2[i - 1]) {
                cur1 = Math.max(cur1, prev2 + 1);
            }

            if (nums2[i] >= nums1[i - 1]) {
                cur2 = Math.max(cur2, prev1 + 1);
            }

            if (nums2[i] >= nums2[i - 1]) {
                cur2 = Math.max(cur2, prev2 + 1);
            }

            ans = Math.max(ans, Math.max(cur1, cur2));
            prev1 = cur1;
            prev2 = cur2;
        }
        if (ans == Integer.MIN_VALUE) return 1;
        return ans;

    }
}
