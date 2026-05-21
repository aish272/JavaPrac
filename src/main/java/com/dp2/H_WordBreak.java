package main.java.com.dp2;

import java.util.*;

public class H_WordBreak {

    public static boolean wordBreak(String s, List<String> wordDict) {
        Map<Integer, Boolean> map = new HashMap<>();
        Set<String> set = new HashSet<>(wordDict);
        return wordBreakUtil(s, set, map, 0);
    }

    public static boolean wordBreakUtil(String s, Set<String> wordDict, Map<Integer, Boolean> map, int index) {

        if (s.length() == index) {
            return true;
        }
        if (map.containsKey(index)) {
            return map.get(index);
        }

        for (int i = index; i < s.length(); i++) {

            if (wordDict.contains(s.substring(index, i + 1))) {

                if (wordBreakUtil(s, wordDict, map, i + 1)) {
                    map.put(index, true);
                    return true;
                }
            }
        }
        map.put(index, false);
        return false;

    }

    public static void main(String[] args) {
        System.out.println(wordBreak("catsandogcat", List.of("cats","dog","sand","and","cat","an")));
    }
}
