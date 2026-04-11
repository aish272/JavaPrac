package main.java.com.dp;

public class R_LongestPalindromicSubsequence {

    public int longestPalindromeSubseq(String s) {
        return getPalindrome(s, new StringBuilder(), 0);
    }

    public int getPalindrome(String s, StringBuilder subsequence, int index) {
        if (index == s.length()) {
            String s1 = String.valueOf(subsequence);
            return getLength(s1);

        }
        subsequence.append(s.charAt(index));
        int with = getPalindrome(s, subsequence, index+1);
        subsequence.deleteCharAt(subsequence.length() - 1);
        int without = getPalindrome(s, subsequence, index+1);

        return Math.max(with,without);
    }

    public int getLength(String s1)
    {
        boolean flag = true;
        for (int i = 0; i < s1.length() / 2; i++) {
            if (s1.charAt(i) == s1.charAt(s1.length()-1-i))
                continue;
            else {
                flag = false;
                break;
            }
        }
        if (flag)
            return s1.length();
        else
            return 0;
    }

    /******************DP ******************/
    public int longestPalindromeSubseqDp(String s) {
        Integer [][] dp = new Integer[s.length()][s.length()];
        return getPalindrome(s, dp, 0, s.length()-1);
    }

    public int getPalindrome(String s, Integer [][] dp, int start, int end) {
        if (start > end) {

            return 0; //out of range

        }
        if(start==end)
        {
            return 1; //string length 1;
        }
        if(dp[start][end]!=null)
            return dp[start][end];
        if(s.charAt(start)==s.charAt(end))
        {
            return dp[start][end] = 2+ getPalindrome(s, dp, start+1, end-1);

        }
        else
        {
            return dp[start][end] = Math.max(getPalindrome(s, dp, start+1, end),getPalindrome(s, dp, start, end-1));
        }
    }
}
