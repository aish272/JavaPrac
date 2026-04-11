package main.java.com.string;

import java.util.HashMap;
import java.util.Map;

public class N_IsomorphicStrings {
    /**
     * <a href="https://leetcode.com/problems/isomorphic-strings/description/">205. Isomorphic Strings</a>
     */
    public static boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length())
            return false;
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i))

                {
                    return false;
                }
            }
            else if (map.containsKey(t.charAt(i))) {
                if (map.get(t.charAt(i)) != s.charAt(i))

                {
                    return false;
                }
            }
            else {
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;


    }

    public static void main(String[] args)
    {
        System.out.println(isIsomorphic("paper","title"));

    }
}
