package main.java.com.dp2;

import java.util.Arrays;

public class L_LongestStringChain {

    /**
     * <a href="https://leetcode.com/problems/longest-string-chain/">1048. Longest String Chain</a>
     */
    public static int longestStrChain(String[] words) {

        int[][] dp = new int[words.length][words.length];
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return getLongestStrChain(words, 0, -1, dp);

    }

    public static int getLongestStrChain(String[] words, int index, int prev, int[][] dp) {
        if (index == words.length) {
            return 0;
        }

        if (prev > -1) {
            if (dp[index][prev] != -1) {
                return dp[index][prev];
            }
        }

        int pick = 0;
        if (prev == -1 || isPredecessor(words[prev], words[index])) {
            pick = 1 + getLongestStrChain(words, index + 1, index, dp);
        }

        int notPick = getLongestStrChain(words, index + 1, prev, dp);

        if (prev > -1) {
            dp[index][prev] = Math.max(pick, notPick);
        }

        return Math.max(pick, notPick);
    }

    public int longestStrChainTab(String[] words) {

        int[] dp = new int[words.length];
        int maxLen = Integer.MIN_VALUE;
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        Arrays.fill(dp, 1);
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < i; j++) {
                if (isPredecessor(words[j], words[i])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLen = Math.max(maxLen, dp[i]);
                }
            }
        }

        return maxLen == Integer.MIN_VALUE ? 1 : maxLen;

    }

    public static boolean isPredecessor(String s1, String s2) {
        int s1Len = s1.length() - 1;
        int s2Len = s2.length() - 1;
        if(s1Len +1 != s2Len)
            return false;

        boolean unmatchedCharCaught = false;

        while (s1Len >= 0 && s2Len >= 0) {
            if (s1.charAt(s1Len) != s2.charAt(s2Len)) {
                if (!unmatchedCharCaught) {
                    unmatchedCharCaught = true;
                    s2Len--;
                } else {
                    return false;
                }
            } else {
                s1Len--;
                s2Len--;
            }
        }
        if (s2Len == 0 && !unmatchedCharCaught)
            return true; //the char at ind==0 in S2 string is different. This char has to be inserted at index 0 in S1 string to make it predecessor and it has not been caught. Hence ans is true.
        return s1Len == s2Len;
    }

    public static void main(String[] args) {
        System.out.println(longestStrChain(new String[] {"wnyxmflkf","xefx","usqhb","ttmdvv","hagmmn","tmvv","pttmdvv","nmzlhlpr","ymfk","uhpaglmmnn","zckgh","hgmmn","isqxrk","isqrk","nmzlhpr","uysyqhxb","haglmmn","xfx","mm","wymfkf","tmdvv","uhaglmmn","mf","uhaglmmnn","mfk","wnymfkf","powttkmdvv","kwnyxmflkf","xx","rnqbhxsj","uysqhb","pttkmdvv","hmmn","iq","m","ymfkf","zckgdh","zckh","hmm","xuefx","mv","iqrk","tmv","iqk","wnyxmfkf","uysyqhb","v","m","pwttkmdvv","rnqbhsj"}));
    }
}
