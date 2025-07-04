package main.java.com.graph;

import java.util.Arrays;

public class M_BipartiteGraphDFS {

    /**
     * <a href="https://leetcode.com/problems/is-graph-bipartite/description/">785. Is Graph Bipartite?</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=KG5YFfR0j8A&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=18">Video solution link</a>
     */
    public static boolean isBipartite(int[][] graph) {
        int vertex = graph.length;
        int [] colorCheck = new int[vertex];
        Arrays.fill(colorCheck,-1);
        for(int index =0; index<vertex; index++)
        {
            if(colorCheck[index]==-1)
            {
                if(!dfs(colorCheck, graph, index, 0))
                    return false;
            }
        }
        return true;
    }

    public static boolean dfs(int [] colorCheck, int[][] graph, int node, int colorToAssign)
    {
        colorCheck[node] = colorToAssign;
        for(int adjNode : graph[node])
        {
            if(colorCheck[adjNode]==-1)
            {
               if(! dfs(colorCheck,graph,adjNode,1-colorCheck[node]))
                   return false;
            } else if (colorCheck[node]==colorCheck[adjNode]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        System.out.println(isBipartite(new int[][]{{3},{2,3},{1,3},{0,2,1}}));
    }
}
