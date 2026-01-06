package main.java.com.graph;

import java.util.ArrayList;

public class W_FindIfPathExistsInGraph {

    /**
     * <a href="https://leetcode.com/problems/find-if-path-exists-in-graph/">1971. Find if Path Exists in Graph</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=mbR1XSXidEE&list=PLpIkg8OmuX-I_49pdy1XFY6OcATnxUrrO&index=4">Video solution link</a>
     */
    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        return dfs(adjList, visited, source, destination);

    }

    public static boolean dfs(ArrayList<ArrayList<Integer>> adjList, boolean[] visited, int source, int destination) {
        if (source == destination) {
            return true;
        }
        if (visited[source]) {
            return false;

        }
        visited[source] = true;
        for (int node : adjList.get(source)) {
            if (dfs(adjList, visited, node, destination)) {
                return true;
            }
        }
        return false;

    }
    public static void main(String[] args) {
        System.out.println(validPath(3,new int[][]{{0,1}, {1, 2}, {2,0}},0,2));
    }
}
