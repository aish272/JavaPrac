package main.java.com.greedyAlgo;

public class N_ReversePalindrome {

    /**
     * <a href="https://leetcode.com/problems/break-a-palindrome/">1328. Break a Palindrome</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=Pbx0Pvyh7D4&list=PLpIkg8OmuX-J8_n8Vy9P9I3KvyDcPMzRU&index=3">Video solution link</a>
     */

    public String breakPalindrome(String palindrome) {

        if (palindrome.length() <= 1)
            return "";
        char[] s = palindrome.toCharArray();
        for (int i = 0; i < s.length / 2; i++) {
            if (s[i] != ('a')) {
                s[i] = 'a';
                return new String(s);

            }

        }
        s[s.length - 1] = 'b';

        return new String(s);
    }
}
