package main.java.com.graph;

import java.util.ArrayList;

public class C_NumberOfProvinces {

    /**
     * <a href="https://leetcode.com/problems/number-of-provinces/">547. Number of Provinces</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=ACzkVtewUYA&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=7">Video solution link</a>
     */
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        int v = isConnected.length;
        for(int i=0; i<v;i++)
        {
            adjList.add(new ArrayList<>());
        }
        for(int i=0; i<v;i++)
        {
            for(int j=i;j<isConnected.length;j++)
            {
                if(isConnected[i][j]==1&&i!=j)
                {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        boolean[] visited = new boolean[v];
        int province=0;
        for(int i=0;i<v;i++)
        {
            if(!visited[i])
            {
                dfs1(i,visited,adjList);
                province++;
            }
        }

        return province;
    }

    private void dfs1(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adjList)
    {
        visited[node] = true;
        for(int num:adjList.get(node))
        {
            if(!visited[num])
            {
                dfs1(num,visited,adjList);
            }
        }
    }
}
