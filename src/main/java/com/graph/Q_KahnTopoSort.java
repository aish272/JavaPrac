package main.java.com.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q_KahnTopoSort {


    /**
     * <a href="https://takeuforward.org/plus/dsa/problems/topological-sort-or-kahns-algorithm">Topological sort or Kahn's algorithm</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=73sneFXuTEg&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=22">Video solution link</a>
     */
    public int[] topoSort(int V, List<List<Integer>> adj) {

        int[] inDegree = new int[V];

        for (int index = 0; index < V; index++) {
            for (int node : adj.get(index)) {
                inDegree[node]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int index = 0; index < V; index++) {
            if (inDegree[index] == 0) {
                queue.offer(index);
            }
        }
        int[] ans = new int[V];
        int counter = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            ans[counter] = node;
            counter++;
            for (int adjNode : adj.get(node)) {
                inDegree[adjNode]--;
                if (inDegree[adjNode] == 0) {
                    queue.offer(adjNode);
                }
            }
        }
        return ans;
    }
}
