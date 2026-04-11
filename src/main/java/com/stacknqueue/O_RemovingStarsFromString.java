package main.java.com.stacknqueue;
import java.util.Stack;

public class O_RemovingStarsFromString {

    /**
     * <a href="https://leetcode.com/problems/removing-stars-from-a-string/">2390. Removing Stars From a String</a>
     */
    public String removeStars(String s) {

        Stack<Character> st = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            while (i < s.length() && s.charAt(i) != '*') {
                st.push(s.charAt(i));
                i++;
            }
            while (i < s.length() && s.charAt(i) == '*') {
                st.pop();
                i++;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();

    }
}
