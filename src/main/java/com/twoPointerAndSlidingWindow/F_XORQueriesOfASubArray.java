package main.java.com.twoPointerAndSlidingWindow;

public class F_XORQueriesOfASubArray {

    /**
     * <a href="https://leetcode.com/problems/xor-queries-of-a-subarray/description/">1310. XOR Queries of a Subarray</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=e6jn1x-Rua8">1310. XOR Queries of a Subarray - LeetCode POTD - 13 September 2024
     */
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] ans = new int[queries.length];
        int[] prefixXor = new int[n];
        prefixXor[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixXor[i] = prefixXor[i - 1] ^ arr[i];
        }
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            if (l == 0) {
                ans[i] = prefixXor[r];
                continue;
            }
            ans[i] = prefixXor[r] ^ prefixXor[l - 1]; //removing the part before l (l-1) by performing xor with the same. Because x^x=0 and 0^x=x;


        }
        return ans;

    }
}
