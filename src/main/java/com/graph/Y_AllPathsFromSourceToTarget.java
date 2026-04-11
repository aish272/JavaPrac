package main.java.com.graph;

import java.util.ArrayList;
import java.util.List;

public class Y_AllPathsFromSourceToTarget {

    /**
     * <a href="https://leetcode.com/problems/all-paths-from-source-to-target/">797. All Paths From Source to Target</a>
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combo = new ArrayList<>();
        dfs(ans, graph, combo, 0);
        return ans;
    }

    public void dfs(List<List<Integer>> ans, int[][] graph, List<Integer> combo, int node) {
        combo.add(node);
        if (combo.get(combo.size() - 1) == graph.length - 1) {
            ans.add(new ArrayList<>(combo));
            return;
        }

        for (int n : graph[node]) {
            dfs(ans, graph, combo, n);
            combo.remove(combo.size() - 1);
        }

    }
}
