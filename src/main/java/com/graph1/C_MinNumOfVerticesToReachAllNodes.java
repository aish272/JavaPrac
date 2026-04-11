package main.java.com.graph1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class C_MinNumOfVerticesToReachAllNodes {

    /**
     * <a href="https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/">1557. Minimum Number of Vertices to Reach All Nodes</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=7wGJ1nevpnc&list=PLpIkg8OmuX-I_49pdy1XFY6OcATnxUrrO&index=26">Video solution link</a>
     */
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {

        Set<Integer> havingIncomingNodes = new HashSet<>();
        List<Integer> unreachable = new ArrayList<>();

        for (List<Integer> e : edges) {
            havingIncomingNodes.add(e.get(1));
        }
        for (int i = 0; i < n; i++) {
            if (!havingIncomingNodes.contains(i)) {

                unreachable.add(i);

            }
        }
        return unreachable;

    }
}
