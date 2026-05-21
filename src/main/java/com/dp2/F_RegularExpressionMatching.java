package main.java.com.dp2;

import java.util.Arrays;

public class F_RegularExpressionMatching {

    /**
     * <a href="https://leetcode.com/problems/regular-expression-matching/">10. Regular Expression Matching</a>
     * <br/>
     * <a href="https://claude.ai/chat/09ee87a9-c711-42d8-837d-d0289dbd7892">Claude solution link</a>
     */
    public boolean isMatch(String s, String p) {
        int indexS = s.length();
        int indexP = p.length();
        int[][] dp = new int[indexS][indexP];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return matched(s, p, indexS - 1, indexP - 1, dp);
    }

    public boolean matched(String s, String p, int indexS, int indexP, int[][] dp) {
        if (indexS < 0 && indexP < 0) {
            return true;
        }
        if (indexS >= 0 && indexP < 0) {
            return false;
        }
        if (indexS < 0 && indexP >= 0) {
            while (indexP >= 1) {
                if (p.charAt(indexP) == '*') {
                    indexP -= 2;
                } else {
                    return false;
                }

            }
            return indexP < 0;
        }
        if (dp[indexS][indexP] != -1) {
            return dp[indexS][indexP] == 1;
        }

        if (s.charAt(indexS) == p.charAt(indexP) || p.charAt(indexP) == '.') {
            dp[indexS][indexP] = matched(s, p, indexS - 1, indexP - 1, dp) ? 1 : 0;
            return dp[indexS][indexP] == 1;
        }

        else if (p.charAt(indexP) == '*') {
            boolean take = false;
            boolean notTake = false;
            notTake = matched(s, p, indexS, indexP - 2, dp);//not taking x* pattern
            if (indexP > 0 && (s.charAt(indexS) == p.charAt(indexP - 1) || p.charAt(indexP - 1) == '.')) {
                take = matched(s, p, indexS - 1, indexP, dp);
            }
            dp[indexS][indexP] = take || notTake ? 1 : 0;
            return dp[indexS][indexP] == 1;

        } else {
            dp[indexS][indexP] = 0;
            return false;
        }

    }
}
