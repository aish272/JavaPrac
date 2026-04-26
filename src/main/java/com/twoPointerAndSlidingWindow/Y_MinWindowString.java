package main.java.com.twoPointerAndSlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class Y_MinWindowString {

    /**
     * <a href="https://leetcode.com/problems/minimum-window-substring/">76. Minimum Window Substring</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=3Bp3OVD1EGc">Video solution link</a>
     */

    public String minWindow(String s, String t) {

        int n = s.length();
        int m = t.length();
        if (n < m) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int countRequired = m;
        int j = 0;
        int i = 0;
        int windowSize = Integer.MAX_VALUE;
        int startIndex = 0;
        while (j < n) {
            char c = s.charAt(j);

            if (map.containsKey(c) && map.get(c) > 0) {
                countRequired--;
            }
            map.put(c, map.getOrDefault(c, 0) - 1);

            while (countRequired == 0) {
                if (windowSize > j - i + 1) {
                    windowSize = j - i + 1;
                    startIndex = i;
                }

                char c1 = s.charAt(i);

                if (map.get(c1) == 0) {
                    countRequired++;

                }
                map.put(c1, map.get(c1) + 1);
                i++;
            }
            j++;
        }
        return windowSize == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + windowSize);
    }
}
