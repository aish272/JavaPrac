package main.java.com.greedyAlgo;

import java.util.Arrays;

public class R_OptimalPartitionOfString {

    /**
     * <a href="https://leetcode.com/problems/optimal-partition-of-string/description/">2405. Optimal Partition of String</a>
     */
    public int partitionString(String s) {

        int ans = 0;
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hash[c - 'a'] == 1) {
                ans++;
                Arrays.fill(hash, 0);
            }
            hash[c - 'a'] = 1;
        }
        ans++; //for the last substring;
        return ans;

    }
}
