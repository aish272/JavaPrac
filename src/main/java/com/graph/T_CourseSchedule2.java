package main.java.com.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class T_CourseSchedule2 {

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int index = 0; index < numCourses; index++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int preReq = prerequisite[1];
            adjList.get(preReq).add(course);
            inDegree[course]++;

        }
        Queue<Integer> queue = new LinkedList<>();
        for (int index = 0; index < numCourses; index++) {
            if (inDegree[index] == 0) {
                queue.offer(index);
            }
        }
        int counter = 0;
        int[] ans = new int[numCourses];
        while (!queue.isEmpty()) {
            int node = queue.poll();
            ans[counter] = node;
            counter++;
            for (int adjNode : adjList.get(node)) {
                inDegree[adjNode]--;
                if (inDegree[adjNode] == 0) {
                    queue.offer(adjNode);
                }
            }
        }
        if(counter!=numCourses)
            return new int[]{};
        return ans;
    }

    public static void main(String[] args)
    {
        System.out.println(Arrays.toString(findOrder(2, new int[][]{{0, 1}, {1, 0}})));
    }
}
