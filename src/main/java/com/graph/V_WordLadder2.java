package main.java.com.graph;

import java.util.*;

public class V_WordLadder2 {


    /**
     * <a href="https://leetcode.com/problems/word-ladder-ii/">126. Word Ladder II</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=DREutrv2XD0&t=1102s">Video solution link</a>
     */

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        //Using a hashset for fast lookup and removal
        HashSet<String> st = new HashSet<>(wordList);

        //Queue will store path on each level. Path is list of string
        Queue<List<String>> q = new LinkedList<>();
        q.offer(new ArrayList<>(Arrays.asList(beginWord)));

        //Track words used in the current BFS level
        List<String> usedWords = new ArrayList<>();
        usedWords.add(beginWord);
        int level = 0;

        //List of shortest path ways : ans list
        List<List<String>> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            List<String> currentPath = q.poll();
            if(level<currentPath.size()) {
                level++;
                for (String used : usedWords) {
                    st.remove(used);
                }
            }

            String currentWrd = currentPath.get(currentPath.size() - 1);

            //If the current word matches the end word;
            if (currentWrd.equals(endWord)) {
                //Ans should be empty or the current path should match the size of already existing shortest path (present in the ans list).
                if (ans.isEmpty() || ans.get(0).size() == currentPath.size()) {
                    ans.add(new ArrayList<>(currentPath));
                    continue;
                }
            }

            //Trying to replace each char of the word with a to z
            char[] wrdArr = currentWrd.toCharArray();
            for (int i = 0; i < wrdArr.length; i++) {
                char og = wrdArr[i];

                for (char c = 'a'; c <= 'z'; c++) {
                    wrdArr[i] = c;
                    String newWrd = new String(wrdArr);

                    //If the new word exists in the set
                    if (st.contains(newWrd))
                    {
                        currentPath.add(newWrd);
                        q.offer(new ArrayList<>(currentPath));
                        usedWords.add(newWrd);
                        currentPath.remove(currentPath.size() - 1); //remove the new word as should not be part of the new path in the next iteration.

                    }
                }
                wrdArr[i] = og;

            }
        }
        return ans;

    }
    public static void main(String[] args)
    {
        findLadders("hit","cog",List.of("hot","dot","dog","lot","log","cog"));
    }


}
