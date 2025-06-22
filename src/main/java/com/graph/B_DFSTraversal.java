package main.java.com.graph;

import java.util.ArrayList;
import java.util.List;

public class B_DFSTraversal {

    public List<Integer> dfsOfGraph(int V, List<List<Integer>> adj) {
        boolean[] visited  = new boolean[V];
        ArrayList<Integer> dfs = new ArrayList<>();
        dfs(0,visited,dfs,adj);
        return dfs;
    }

    public void dfs(int node,boolean[] visited,ArrayList<Integer> dfs,List<List<Integer>> adj)
    {
        visited[node] = true;
        dfs.add(node);
        for(int vicino:adj.get(node))
        {
            if(!visited[vicino])
            {
                dfs(vicino,visited,dfs,adj);
            }
        }
    }


}
