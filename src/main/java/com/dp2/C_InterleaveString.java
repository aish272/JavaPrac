package main.java.com.dp2;

import java.util.Arrays;

public class C_InterleaveString {

    /**
     * <a href="https://leetcode.com/problems/interleaving-string/description/">97. Interleaving String</a>
     * <br/>
     * <a href="https://chatgpt.com/c/69fe3f3f-4b80-8324-b147-a2451b4a273d">ChatGPT solution link</a>
     */
    public static boolean isInterleave(String s1, String s2, String s3) {
        return returnBool(s1, s2, s3, 0, 0, new StringBuilder());
    }

    public static  boolean returnBool(String s1, String s2, String s3, int indexS1, int indexS2, StringBuilder s) {
        if (s.length() == s3.length()) {
            return s.toString().equals(s3) && indexS1 == s1.length() && indexS2 == s2.length();
        }
        boolean pickS1 = false;
        boolean pickS2 = false;
        if (indexS1 < s1.length()) {
            pickS1 = returnBool(s1, s2, s3, indexS1 + 1, indexS2, s.append(s1.charAt(indexS1)));
            s.deleteCharAt(s.length()-1);
        }
        if (indexS2 < s2.length()) {
            pickS2 = returnBool(s1, s2, s3, indexS1, indexS2 + 1, s.append(s2.charAt(indexS2)));
            s.deleteCharAt(s.length()-1);
        }

        return pickS1 || pickS2;

    }

    public static boolean isInterleaveDP(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return returnBool(s1, s2, s3, 0, 0, dp);
    }

    public static boolean returnBool(String s1, String s2, String s3, int indexS1, int indexS2, int[][] dp) {

        if (indexS1 == s1.length() && indexS2 == s2.length())
            return true;

        if (dp[indexS1][indexS2] != -1)
            return dp[indexS1][indexS2] == 1;

        boolean pickS1 = false;
        boolean pickS2 = false;
        int k = indexS1 + indexS2;
        if (indexS1 < s1.length() && s1.charAt(indexS1) == s3.charAt(k)) {
            pickS1 = returnBool(s1, s2, s3, indexS1 + 1, indexS2, dp);

        }
        if (indexS2 < s2.length() && s2.charAt(indexS2) == s3.charAt(k)) {
            pickS2 = returnBool(s1, s2, s3, indexS1, indexS2 + 1, dp);

        }

        if (pickS1 || pickS2)
            dp[indexS1][indexS2] = 1;
        else
            dp[indexS1][indexS2] = 0;

        return pickS1 || pickS2;

    }

    public static void main(String[] args) {
        System.out.println(isInterleaveDP("a","b","a"));
    }
}
