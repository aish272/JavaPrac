package main.java.com.graph;

import java.util.*;

public class A_BFSTraversal {


    public List<Integer> bfsOfGraph(int V, List<List<Integer>> adj) {

        boolean[] visited = new boolean[V];
        Queue<Integer> track = new LinkedList<>();
        ArrayList<Integer> bfs = new ArrayList<>();

        track.offer(0);
        visited[0] = true;
        while (!track.isEmpty())
        {
            int node = track.poll();
            bfs.add(node);
            for(int i: adj.get(node))
            {
                if(!visited[i]) {
                    track.offer(i);
                    visited[i] = true;
                }
            }
        }
        return bfs;
    }
}
