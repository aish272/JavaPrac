package main.java.com.string;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class V_ReplaceWords {

    /**
     * <a href="https://leetcode.com/problems/replace-words/">648. Replace Words</a>
     */

    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> dict = new HashSet<>(dictionary);
        String[] arr = sentence.split(" ");
        for (String s : arr) {
            for (int i = 0; i < s.length(); i++) {
                if (dict.contains(s.substring(0, i + 1))) {
                    sentence = sentence.replaceFirst(s, s.substring(0, i + 1));
                    break;
                }
            }
        }
        return sentence;

    }
}
