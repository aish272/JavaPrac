package main.java.com.graph1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A_Possible_Bipartition {

    /**
     * <a href="https://leetcode.com/problems/possible-bipartition/description/">886. Possible Bipartition</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=KG5YFfR0j8A&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=18">Video solution link</a>
     */
    public static boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] dislike : dislikes) {
            adjList.get(dislike[0]).add(dislike[1]);
            adjList.get(dislike[1]).add(dislike[0]);
        }
        int[] grouping = new int[n + 1];
        Arrays.fill(grouping, -1);
        for (int i = 1; i < grouping.length; i++) {
            if (grouping[i] == -1) {
                if (!dfs(adjList, grouping, 0, i))
                    return false;
            }
        }
        return true;
    }

    public static boolean dfs(List<List<Integer>> adjList, int[] grouping, int groupToAssign, int node) {
        grouping[node] = groupToAssign;
        for (int adjNode : adjList.get(node)) {
            if (grouping[adjNode] == -1) {
                if (!dfs(adjList, grouping, 1 - grouping[node], adjNode))
                    return false;

            } else if (grouping[node] == grouping[adjNode])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(possibleBipartition(3, new int[][]{{1, 2}, {1, 3}, {2, 3}}));
    }
}
