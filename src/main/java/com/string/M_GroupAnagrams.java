package main.java.com.string;

import java.util.*;

public class M_GroupAnagrams {
    /**
     * <a href="https://leetcode.com/problems/group-anagrams/">49. Group Anagrams</a>
     */
    public static List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            List<String> subAns = new ArrayList<>();
            if (strs[i].contains("_"))
                continue;
            for (int j = i + 1; j < strs.length; j++) {
                if (strs[i].length() != strs[j].length())
                    continue;

                String temp = strs[j];
                boolean flag = true;
                for (String val : strs[i].split("")) {
                    if (strs[j].contains(val)) {
                        strs[j]=strs[j].replaceFirst(val, "_");
                    } else {
                        flag = false;
                        break;
                    }
                }
                strs[j] = temp;
                if (flag) {

                    subAns.add(strs[j]);
                    strs[j] = strs[j].replaceAll(strs[j], "_");
                }

            }
            subAns.add(strs[i]);
            ans.add(subAns);
        }
        return ans;
    }

    public static List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr); // O(k log k)
            String key = new String(arr);

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args)
    {
        System.out.println( groupAnagrams1(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
}
