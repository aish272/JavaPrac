package main.java.com.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class R_CycleInDirectedGraph_BFS {

    /**
     * <a href="https://takeuforward.org/plus/dsa/problems/detect-a-cycle-in-a-directed-graph">Detect a cycle in a directed graph</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=iTBaI90lpDQ&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=23">Video solution link</a>
     */
    public boolean isCyclic(int N, List<List<Integer>> adj) {

        int[] inDegree = new int[N];

        for (int index = 0; index < N; index++) {
            for (int node : adj.get(index)) {
                inDegree[node]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int index = 0; index < N; index++) {
            if (inDegree[index] == 0) {
                queue.offer(index);
            }
        }
        int count =0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;
            for (int adjNode : adj.get(node)) {
                inDegree[adjNode]--;
                if (inDegree[adjNode] == 0) {
                    queue.offer(adjNode);
                }
            }
        }
        return !(count==N);
    }
}
