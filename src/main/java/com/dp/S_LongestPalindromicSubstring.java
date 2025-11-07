package main.java.com.dp;

public class S_LongestPalindromicSubstring {

    /***dp*/
    public static String longestPalindromeDP(String s) {

        String[][] dp = new String[s.length()][s.length()];

        return returnLongestPalindrome(0, s.length(), s, dp);

    }

    public static String returnLongestPalindrome(int start, int end, String s, String[][] dp) {
        if (start > end) return "";
        if (dp[start][end - 1] != null) return dp[start][end - 1];
        if (isPalindromeDp(s.substring(start, end)) > 0) return s.substring(start, end);

        String s1 = returnLongestPalindrome(start + 1, end, s, dp);
        String s2 = returnLongestPalindrome(start, end - 1, s, dp);

        return dp[start][end - 1] = s1.length() > s2.length() ? s1 : s2;

    }

    public static int isPalindromeDp(String s) {
        int ans = 0;
        if (s.length() == 1) return 1;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) == s.charAt(s.length() - 1 - i)) {
                ans++;
            } else {
                return 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        longestPalindromeDP("a");
    }

    /**
     * <a href="https://leetcode.com/problems/longest-palindromic-substring/">5. Longest Palindromic Substring</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=_wP9mWNPL5w">Video solution link</a>
     */


    public String longestPalindrome(String s) {

        return returnLongestPalindrome(0, s.length(), s);

    }

    public String returnLongestPalindrome(int start, int end, String s) {
        if (start > end) return "";
        if (isPalindrome(s.substring(start, end)) > 0) return s.substring(start, end);

        String s1 = returnLongestPalindrome(start + 1, end, s);
        String s2 = returnLongestPalindrome(start, end - 1, s);

        return s1.length() > s2.length() ? s1 : s2;

    }

    public int isPalindrome(String s) {
        int ans = 0;
        if (s.length() == 1) return 1;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) == s.charAt(s.length() - 1 - i)) {
                ans++;
            } else {
                return 0;
            }
        }
        return ans;
    }
}
