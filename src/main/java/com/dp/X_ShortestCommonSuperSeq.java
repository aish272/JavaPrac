package main.java.com.dp;

public class X_ShortestCommonSuperSeq {

    /**
     * <a href="https://leetcode.com/problems/shortest-common-supersequence/">1092. Shortest Common Supersequence</a>
     */
    public String shortestCommonSupersequence(String str1, String str2) {
        int ind1 = str1.length() + 1;
        int ind2 = str2.length() + 1;
        int[][] dp = new int[ind1][ind2];

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int i = str1.length();
        int j = str2.length();
        StringBuilder ans = new StringBuilder();

        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                ans.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                ans.append(str1.charAt(i - 1));
                i--;
            } else {
                ans.append(str2.charAt(j - 1));
                j--;
            }
        }
        while (i > 0) {
            ans.append(str1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            ans.append(str2.charAt(j - 1));
            j--;
        }

        return ans.reverse().toString();

    }

}
