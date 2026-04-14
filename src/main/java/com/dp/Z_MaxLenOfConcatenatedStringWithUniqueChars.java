package main.java.com.dp;

import java.util.List;

public class Z_MaxLenOfConcatenatedStringWithUniqueChars {

    /**
     * <a href="https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/">1239. Maximum Length of a Concatenated String with Unique Characters</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=MqMvkrkerIY&list=PLpIkg8OmuX-L_QqcKB5abYynQbonaNcq3&index=2">Video solution link</a>
     */
    public int maxLength(List<String> arr) {
        return returnMaxLen(arr, 0, "");
    }

    public int returnMaxLen(List<String> arr, int index, String temp) {
        if (index == arr.size()) {
            return temp.length();
        }

        int take = 0;
        int notTake = 0;
        if (!hasDuplicate(arr.get(index), temp)) {
            take = returnMaxLen(arr, index + 1, temp.concat(arr.get(index)));
        }
        notTake = returnMaxLen(arr, index + 1, temp);
        return Math.max(take, notTake);
    }

    public boolean hasDuplicate(String s1, String s2) {
        int[] hash = new int[26];
        for (char c : s1.toCharArray()) {
            if (hash[c - 'a'] > 0) return true;

            hash[c - 'a']++;

        }

        for (char c : s2.toCharArray()) {
            if (hash[c - 'a'] > 0) return true;

            hash[c - 'a']++;

        }
        return false;
    }
}
