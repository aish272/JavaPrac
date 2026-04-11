package main.java.com.graph;

import java.util.List;

public class X_KeysAndRooms {

    /**
     * <a href="https://leetcode.com/problems/keys-and-rooms/">841. Keys and Rooms</a>
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean[] visited = new boolean[rooms.size()];
        dfs(visited, rooms, 0);
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;

    }

    public void dfs(boolean[] visited, List<List<Integer>> rooms, int node) {
        visited[node] = true;
        for (int n : rooms.get(node)) {
            if (!visited[n]) {
                dfs(visited, rooms, n);
            }
        }

    }
}
