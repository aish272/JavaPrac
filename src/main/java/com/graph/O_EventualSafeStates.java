package main.java.com.graph;

import java.util.ArrayList;
import java.util.List;

public class O_EventualSafeStates {

    /**
     * <a href="https://leetcode.com/problems/find-eventual-safe-states/description/">802. Find Eventual Safe States</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=uRbJ1OF9aYM&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=20">Video solution link</a>
     */

    public List<Integer> eventualSafeNodes(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        boolean[] pathVisited = new boolean[graph.length];
        for (int index = 0; index < visited.length; index++) {
            if (!visited[index]) {
                dfs(visited, pathVisited, index, graph);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int index = 0; index < pathVisited.length; index++) {
            if(!pathVisited[index])
                ans.add(index);
        }
        return ans;
    }

    private boolean dfs(boolean[] visited, boolean[] pathVisited, int node, int[][] graph )
    {
        visited[node] = true;
        pathVisited[node] = true;
        for(int adjNode: graph[node])
        {
            if(!visited[adjNode])
            {
                if(dfs(visited, pathVisited, adjNode, graph))
                {
                    return true;
                }
            }
            if(pathVisited[adjNode])
            {
                return true;
            }
        }
        pathVisited[node] = false;
        return false;
    }
}
