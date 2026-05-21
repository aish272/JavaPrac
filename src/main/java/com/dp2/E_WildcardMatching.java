package main.java.com.dp2;

import java.util.Arrays;

public class E_WildcardMatching {

    /**
     * <a href="https://leetcode.com/problems/wildcard-matching/description/">44. Wildcard Matching</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=ZmlQ3vgAOMo&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=35">Video solution link</a>
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
        if (indexS < 0 && indexP < 0) // s and p are exhausted
        {
            return true;
        }
        if (indexS >= 0 && indexP < 0) //pattern is exhasted
        {
            return false;
        }

        if (indexS < 0 && indexP >= 0) // s is exhausted
        {
            while (indexP >= 0) {
                if (p.charAt(indexP) != '*')
                    return false;
                indexP--;

            }
            return true;

        }
        if (dp[indexS][indexP] != -1)
            return dp[indexS][indexP] == 1;
        if (s.charAt(indexS) == p.charAt(indexP) || p.charAt(indexP) == '?') {

            dp[indexS][indexP] = matched(s, p, indexS - 1, indexP - 1, dp) ? 1 : 0;

            return dp[indexS][indexP] == 1;
        } else if (p.charAt(indexP) == '*') {
            //not take * || take *
            dp[indexS][indexP] = matched(s, p, indexS, indexP - 1, dp) || matched(s, p, indexS - 1, indexP, dp) ? 1 : 0;
            return dp[indexS][indexP] == 1;
        }

        dp[indexS][indexP] = 0;
        return false;

    }
}
