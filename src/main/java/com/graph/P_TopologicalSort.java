package main.java.com.graph;

import java.util.List;
import java.util.Stack;

public class P_TopologicalSort {

    /**
     * <a href="https://takeuforward.org/plus/dsa/problems/topological-sort-or-kahns-algorithm">Topological sort or Kahn's algorithm</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=73sneFXuTEg&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=22">Video solution link</a>
     */
    public int[] topoSort(int V, List<List<Integer>> adj) {

        boolean[] visited = new boolean[V];
        Stack<Integer> s = new Stack<>();
        for(int index=0;index<V;index++)
        {
            if(!visited[index])
            {
                dfs(visited,index,adj,s);
            }

        }
        int[] ans = new int [V];
        for(int index=0;index<V;index++)
        {
            ans[index] = s.pop();
        }
        return ans;

    }
    private void dfs(boolean[] visited, int node, List<List<Integer>> adj, Stack<Integer> s)
    {
        visited[node] = true;
        for(int adjnode : adj.get(node))
        {
            if(!visited[adjnode])
            {
                dfs(visited,adjnode,adj,s);
            }
        }
        s.push(node);
    }
}
