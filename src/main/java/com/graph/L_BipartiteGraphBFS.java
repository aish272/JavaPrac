package main.java.com.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class L_BipartiteGraphBFS {

    /**
     * <a href="https://leetcode.com/problems/is-graph-bipartite/description/">785. Is Graph Bipartite?</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=-vu34sct1g8&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=17">Video solution link</a>
     */
    public boolean isBipartite(int[][] graph) {


        int vertex = graph.length;
        int [] colorCheck = new int[vertex];
        Arrays.fill(colorCheck,-1);
        for(int i =0;i<vertex;i++)
        {
            if(colorCheck[i]==-1)
            {
                if(!check(i, colorCheck,graph)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean check(int node, int[] colorCheck,int[][] graph)
    {
        Queue<Integer> track = new LinkedList<>();
        track.offer(node);
        colorCheck[node] =0;
        while (!track.isEmpty())
        {
            int currNode = track.poll();
            for(int i =0;i<graph[currNode].length;i++)
            {
                int adjNode = graph[currNode][i];
                if(colorCheck[adjNode]==-1)
                {
                    colorCheck[adjNode] = 1 - colorCheck[currNode];
                    track.offer(adjNode);
                }
                else if(colorCheck[adjNode]==colorCheck[currNode])
                    return false;
            }
        }
        return true;
    }
}
