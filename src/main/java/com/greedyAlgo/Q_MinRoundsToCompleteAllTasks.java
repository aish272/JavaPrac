package main.java.com.greedyAlgo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q_MinRoundsToCompleteAllTasks {

    /**
     * <a href="https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/">2244. Minimum Rounds to Complete All Tasks</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=uY3mWwJvRkA&list=PLpIkg8OmuX-J8_n8Vy9P9I3KvyDcPMzRU&index=11">Video solution link</a>
     */
    public static int minimumRounds(int[] tasks) {
        Arrays.sort(tasks);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }
        if (map.containsValue(1)) {
            return -1;
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> ele : map.entrySet()) {
            int freq = ele.getValue();
            if (freq % 3 == 0) {
                ans += freq / 3;
            } else if (freq % 3 == 2 || freq % 3 == 1) {
                ans += freq / 3;
                ans++;
            }
            else {
                return -1;
            }
        }
        return ans;

    }
    public static void main(String[] args) {
        minimumRounds(new int[]{66,66,63,61,63,63,64,66,66,65,66,65,61,67,68,66,62,67,61,64,66,60,69,66,65,68,63,60,67,62,68,60,66,64,60,60,60,62,66,64,63,65,60,69,63,68,68,69,68,61});
    }
}
