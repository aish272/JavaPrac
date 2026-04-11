package main.java.com.priorityqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class D_SortCharsByFrequency {

    /**
     * <a href="https://leetcode.com/problems/sort-characters-by-frequency/">451. Sort Characters By Frequency</a>
     */
    public static String frequencySort(String s) {

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String s1 = s.substring(i, i + 1);
            map.put(s1, map.getOrDefault(s1, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Map.Entry<String, Integer> ele : map.entrySet()) {
            pq.add(ele.getValue());
        }
        StringBuilder s3 = new StringBuilder();
        int size = pq.size();
        while (size > 0) {
            int freq = pq.poll();
            for (Map.Entry<String, Integer> ele : map.entrySet()) {
                if(freq==ele.getValue())
                {
                    while(freq>0)
                    {
                        s3.append(ele.getKey());
                        freq--;
                    }
                    map.remove(ele.getKey());
                    break;
                }

            }
            size--;
        }
        return s3.reverse().toString();

    }

    public static void main(String[] args) {

        System.out.println(frequencySort("raaeaedere"));
    }

}
