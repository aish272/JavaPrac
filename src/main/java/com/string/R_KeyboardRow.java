package main.java.com.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class R_KeyboardRow {

    /**
     * <a href="https://leetcode.com/problems/keyboard-row/">500. Keyboard Row</a>
     */
    public static String[] findWords(String[] words) {

        Set<String> row1 = new HashSet<>(List.of("qwertyuiop".split("")));
        Set<String> row2 = new HashSet<>(List.of("asdfghjkl".split("")));
        Set<String> row3 = new HashSet<>(List.of("zxcvbnm".split("")));
        List<String> ans = new ArrayList<>();

        for (String w : words) {
            String w1 = w.toLowerCase();
            Set<String> word = new HashSet<>(List.of(w1.split("")));

            if ((row1.containsAll(word) || row2.containsAll(word)) || row3.containsAll(word)) {
                ans.add(w);
            }
        }
        return ans.toArray(new String[0]);


    }

    public static void main(String[] args) {
        findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"});
    }

    public String[] findWordsOptimised(String[] words) {

        int[] mapping = new int[26];
        List<String> ans = new ArrayList<>();

        for (char c : "qwertyuiop".toCharArray()) {
            mapping[c - 'a'] = 1;

        }
        for (char c : "asdfghjkl".toCharArray()) {
            mapping[c - 'a'] = 2;

        }
        for (char c : "zxcvbnm".toCharArray()) {
            mapping[c - 'a'] = 3;

        }
        for (String word : words) {
            String w1 = word.toLowerCase();
            int rowOfFirstChar = mapping[w1.charAt(0) - 'a'];
            boolean toAdd = true;
            for (int i = 0; i < word.length(); i++) {
                if (mapping[w1.charAt(i) - 'a'] != rowOfFirstChar) {
                    toAdd = false;
                    break;
                }
            }
            if (toAdd) {
                ans.add(word);
            }

        }
        return ans.toArray(new String[0]);
    }
}
