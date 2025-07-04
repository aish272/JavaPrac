package main.java.com.graph;

import java.util.List;

public class N_CycleInDirectedGraph_DFS {

    /**
     * <a href="https://takeuforward.org/plus/dsa/problems/detect-a-cycle-in-a-directed-graph">Detect a cycle in a directed graph</a>
     * <br/>
     * <a href="https:/https://www.youtube.com/watch?v=9twcmtQj4DU&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=19">Video solution link</a>
     */
    public boolean isCyclic(int N, List<List<Integer>> adj) {
        boolean[] visited = new boolean[N];
        boolean[] pathVisited = new boolean[N];
        for(int index =0;index<N;index++)
        {
            if(!visited[index])
            {
                if(dfs(visited,pathVisited,index,adj))
                {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(boolean[] visited, boolean[] pathVisited, int vertex, List<List<Integer>> adj)
    {
        visited[vertex] = true;
        pathVisited[vertex] = true;
        for(int v : adj.get(vertex))
        {
            if(!visited[v])
            {
                if(dfs(visited,pathVisited,v,adj))
                {
                    return true;
                }
            }
            else if (pathVisited[v])
            {

                return true;

            }

        }
        pathVisited[vertex] = false;
        return false;
    }
}
