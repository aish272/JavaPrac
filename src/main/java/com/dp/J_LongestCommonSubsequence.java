package main.java.com.dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class J_LongestCommonSubsequence {

    public static int longestCommonSubsequence(String text1, String text2) {
        List<String> sub1 = new LinkedList<>();
        List<String> sub2 = new LinkedList<>();
        generateSubsequence(text1,new StringBuilder(),sub1,0);
        generateSubsequence(text2,new StringBuilder(),sub2,0);
        int max = 0;
        for(String s: sub1)
        {
            if(sub2.contains(s))
            {
                max = Math.max(max,s.length());
            }
        }
        return max;

    }

    public static void generateSubsequence(String text, StringBuilder subsequence, List<String> subList, int index)
    {
        if(index>=text.length()) {
            subList.add(String.valueOf(subsequence));
            return;
        }
        subsequence.append(text.charAt(index));
        generateSubsequence(text,subsequence,subList,index+1);
        subsequence.deleteCharAt(subsequence.length()-1);
        generateSubsequence(text,subsequence,subList,index+1);
    }

    public static int longestCommonSubsequenceDP(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int [] arr: dp)
        {
            Arrays.fill(arr,-1);
        }
        return returnLongestSubsequenceLen(text1.length()-1,text2.length()-1,dp,text1,text2);

    }

    public static int returnLongestSubsequenceLen(int index1, int index2, int[][] dp,String text1, String text2)
    {
        if(index1<0||index2<0)
            return 0;
        if(dp[index1][index2]!=-1)
            return dp[index1][index2];
        if(text1.charAt(index1)==text2.charAt(index2))
        {
            return dp[index1][index2]=1 + returnLongestSubsequenceLen(index1-1,index2-1,dp,text1,text2);
        }
        else
        {
            return dp[index1][index2]=Math.max(returnLongestSubsequenceLen(index1 - 1, index2, dp, text1, text2),
                   returnLongestSubsequenceLen(index1, index2 - 1, dp, text1, text2));
        }

    }

    public static int longestCommonSubsequenceTab(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int i =1;i<=text1.length();i++ )
        {
            for(int j =1;j<=text2.length();j++ )
            {
                if(text1.charAt(i-1)==text2.charAt(j-1))
                {
                    dp[i][j]=1 + dp[i-1][j-1];
                }
                else
                {
                    dp[i][j]=Math.max(dp[i - 1][ j], dp[i][ j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }



    public static void main(String[] args) {

        System.out.println(longestCommonSubsequenceTab("de","ee"));
    }
}
