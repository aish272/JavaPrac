package main.java.com.dp2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class I_WordBreak2 {

    public static ArrayList<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        return wordBreakUtil(s, set, 0, new ArrayList<>(), new ArrayList<>());
    }

    public static ArrayList<String> wordBreakUtil(String s, Set<String> wordDict, int index, ArrayList<String> ans, ArrayList<String> segment) {

        if (s.length() == index) {
            StringBuilder str = new StringBuilder(segment.get(0));
            for (int i = 1; i < segment.size(); i++) {
                str.append(" ").append(segment.get(i));
            }
            ans.add(str.toString());
        }

        for (int i = index; i < s.length(); i++) {
            if (wordDict.contains(s.substring(index, i + 1))) {
                segment.add(s.substring(index, i + 1));
                wordBreakUtil(s, wordDict, i + 1, ans, segment);
                segment.remove(segment.size() - 1);
            }


        }


        return ans;

    }

    public static void main(String[] args) {
        System.out.println(wordBreak("catsandogcat", List.of("cats", "dog", "sand", "and", "cat", "an")));
    }

}
