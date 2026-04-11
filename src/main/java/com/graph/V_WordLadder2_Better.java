package main.java.com.graph;

import java.util.*;

public class V_WordLadder2_Better {


    /**
     * <a href="https://leetcode.com/problems/word-ladder-ii/">126. Word Ladder II</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=AD4SFl7tu7I">Video solution link</a>
     */

    static List<List<String>> ans;

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        //Using a hashset for fast lookup and removal
        HashSet<String> st = new HashSet<>(wordList);


        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        HashMap<String, Integer> map = new HashMap<>();
        map.put(beginWord,1);
        st.remove(beginWord);

        while (!q.isEmpty()) {
            String currentWrd = q.poll();
            int steps = map.get(currentWrd);

            //If the current word matches the end word;
            if (currentWrd.equals(endWord)) {
                break;
            }

            char[] wrdArr = currentWrd.toCharArray();
            for (int i = 0; i < wrdArr.length; i++) {
                char og = wrdArr[i];


                for (char c = 'a'; c <= 'z'; c++) {
                    wrdArr[i] = c;
                    String newWrd = new String(wrdArr);


                    //If the new word exists in the set
                    if (st.contains(newWrd))
                    {

                        q.offer(newWrd);
                        st.remove(newWrd);
                        map.put(newWrd,steps+1);

                    }
                }
                wrdArr[i] = og;


            }
        }
        //List of shortest path ways : ans list
        ans = new ArrayList<>();
        if(map.containsKey(endWord)) {
            List<String> path = new ArrayList<>();
            path.add(endWord);
            dfs(endWord, path, beginWord, map);
        }
        return ans;

    }

    private static void dfs(String wrd, List<String> path, String beginWord, HashMap<String, Integer> map) {
        if (wrd.equals(beginWord)) {
            List<String> path1 = new ArrayList<>(path);
            Collections.reverse(path1);
            ans.add(path1);
            return;
        }
        char[] wrdArr = wrd.toCharArray();
        int steps = map.get(wrd);
        for (int i = 0; i < wrdArr.length; i++) {
            char og = wrdArr[i];

            for (char c = 'a'; c <= 'z'; c++) {
                wrdArr[i] = c;
                String newWrd = new String(wrdArr);

                //If the new word exists in the set
                if (map.containsKey(newWrd) && map.get(newWrd) + 1 == steps) {

                    path.add(newWrd);
                    dfs(newWrd, path,beginWord,map);
                    path.remove(path.size() - 1);

                }
            }
            wrdArr[i] = og;

        }

    }
    public static void main(String[] args)
    {
        System.out.println(findLadders("hit","cog",List.of("hot","dot","dog","lot","log")));
    }


}
