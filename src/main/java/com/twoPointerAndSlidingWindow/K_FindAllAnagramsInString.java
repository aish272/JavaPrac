package main.java.com.twoPointerAndSlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class K_FindAllAnagramsInString {

    /**
     * <a href="https://leetcode.com/problems/find-all-anagrams-in-a-string/">438. Find All Anagrams in a String</a>
     */
    public List<Integer> findAnagrams(String s, String p) {

        int left = 0;
        int right = p.length() - 1;
        List<Integer> ans = new ArrayList<>();
        char[] pArr = p.toCharArray();
        Arrays.sort(pArr);
        while (right < s.length()) {
            char[] sArr = s.substring(left, right + 1).toCharArray();
            Arrays.sort(sArr);
            if (Arrays.equals(pArr, sArr)) {
                ans.add(left);
            }
            left++;
            right++;
        }
        return ans;
    }
}
