package main.java.com.stacknqueue;

import java.util.Stack;

public class M_RemoveAllAdjDupeString {

    /**
     * <a href="https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/">1047. Remove All Adjacent Duplicates In String</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=VeOUal3_s6c&list=PLpIkg8OmuX-IA6_cJxfTYCmnv1jkqox47&index=2">Video solution link</a>
     */
    public String removeDuplicates(String s) {
        Stack<String> st = new Stack<>();
        st.push(s.substring(0, 1));
        for (int i = 1; i < s.length(); i++) {
            String s1 = s.substring(i, i + 1);
            if (!st.isEmpty() && st.peek().equals(s1)) {
                st.pop();
            } else {
                st.push(s1);
            }

        }
        s = "";
        for(String s1: st)
        {
            s = s.concat(s1);
        }
        return s;

    }
}
