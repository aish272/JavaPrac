package main.java.com.graph;

import java.util.LinkedList;
import java.util.Queue;

public class S_CourseSchedule1 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];

        for (int index = 0; index < numCourses; index++) {
            for (int node : prerequisites[index]) {
                inDegree[node]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int index = 0; index < numCourses; index++) {
            if (inDegree[index] == 0) {
                queue.offer(index);
            }
        }
        int counter = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            counter++;
            for (int adjNode : prerequisites[node]) {
                inDegree[adjNode]--;
                if (inDegree[adjNode] == 0) {
                    queue.offer(adjNode);
                }
            }
        }
        return !(counter==numCourses);
    }
}
