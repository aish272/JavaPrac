package main.java.com.graph1;

import java.util.ArrayList;
import java.util.List;

public class B_MinTimeToCollectAllApples {

    /**
     * <a href="https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/">1443. Minimum Time to Collect All Apples in a Tree</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=qSBvKlUq0xo&list=PLpIkg8OmuX-I_49pdy1XFY6OcATnxUrrO&index=9">Video solution link</a>
     */
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            int p = e[0];
            int c = e[1];
            adjList.get(p).add(c);
            adjList.get(c).add(p);
        }
        return returnMinTime(adjList, hasApple, 0, -1);

    }

    public int returnMinTime(List<List<Integer>> adjList, List<Boolean> hasApple, int current, int parent) {
        int time = 0;
        for (int child : adjList.get(current)) {
            if (child == parent) continue; //will not tread back in the same path towards parent
            int timeTakenByChild = returnMinTime(adjList, hasApple, child, current);
            if (timeTakenByChild > 0 || hasApple.get(child)) {
                time += timeTakenByChild + 2;
            }
        }
        return time;

    }
}
