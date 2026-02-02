package main.java.com.string;

public class W_SplitAStringInBalancedStrings {

    /**
     * <a href="https://leetcode.com/problems/split-a-string-in-balanced-strings/">1221. Split a String in Balanced Strings</a>
     */
    public int balancedStringSplit(String s) {
        int countL = 0;
        int countR = 0;
        int ans = 0;
        int index = 0;
        while (index < s.length()) {
            if (s.charAt(index) == 'R') {
                countR++;
            } else {
                countL++;
            }
            if (countL == countR) {
                ans++;
                countL = 0;
                countR = 0;
            }
            index++;
        }
        return ans;

    }

}
