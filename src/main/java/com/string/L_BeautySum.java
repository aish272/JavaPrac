package main.java.com.string;

public class L_BeautySum {
    /**
     * <a href="https://leetcode.com/problems/sum-of-beauty-of-all-substrings/">1781. Sum of Beauty of All Substrings</a>
     */
    public static int beautySum(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] hash = new int[26];

            for (int j = i; j < s.length(); j++) {
                int charPosition = s.charAt(j) - 'a';
                hash[charPosition]++;
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                for (int num : hash) {
                    max = Math.max(max, num);
                    if (num != 0) {
                        min = Math.min(min, num);
                    }
                }
                sum += max - min;
            }

        }
        return sum;
    }

    public static void main(String[] args)
    {
        System.out.println( beautySum("aabcb"));
    }
}
