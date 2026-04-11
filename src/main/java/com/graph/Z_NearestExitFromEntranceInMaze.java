package main.java.com.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Z_NearestExitFromEntranceInMaze {

    /**
     * <a href="https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/description/">1926. Nearest Exit from Entrance in Maze</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=Q4bqto_yG6I&list=PLpIkg8OmuX-I_49pdy1XFY6OcATnxUrrO&index=3">BFS Video solution link</a>
     */
    public static int[][] directions = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    //DFS Solution
    public static int nearestExit(char[][] maze, int[] entrance) {
        return dfs(maze, entrance, entrance[0], entrance[1], 0);
    }

    public static int dfs(char[][] maze, int[] entrance, int row, int col, int steps) {
        if (row < 0 || row == maze.length || col < 0 || col == maze[0].length || maze[row][col] == '+' || maze[row][col] == '$') {
            return -1;
        }

        if ((row == 0 || row == maze.length - 1 || col == 0 || col == maze[0].length - 1) && !(row == entrance[0] && col == entrance[1])) {
            return steps;
        }

        int minSteps = Integer.MAX_VALUE;
        char og = maze[row][col];
        maze[row][col] = '$';
        for (int[] dir : directions) {
            int newR = row + dir[0];
            int newC = col + dir[1];
            int s = dfs(maze, entrance, newR, newC, steps + 1);
            if (s != -1) {
                minSteps = Math.min(minSteps, s);
            }

        }
        maze[row][col] = og;
        return minSteps;
    }

    //BFS Solution
    public static int nearestExitBFS(char[][] maze, int[] entrance) {

        int level = -1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(entrance);
        while (!q.isEmpty()) {
            int size = q.size();
            level++;
            for (int i = 0; i < size; i++) {
                int[] current = q.poll();
                int row = current[0];
                int col = current[1];
                if (row < 0 || row == maze.length || col < 0 || col == maze[0].length || maze[row][col] == '+') {
                    continue;
                }

                if ((row == 0 || row == maze.length - 1 || col == 0 || col == maze[0].length - 1)
                        && !(row == entrance[0] && col == entrance[1]))

                    return level;

                for (int[] dir : directions) {
                    int newR = row + dir[0];
                    int newC = col + dir[1];
                    q.offer(new int[] { newR, newC });

                }
                maze[row][col] = '+'; //mark visited

            }

        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(nearestExitBFS(new char[][]{{'+', '+', '.','+'}, {'.', '.', '.','+'}, {'+', '+', '+','.'}}, new int[]{1, 2}));
    }
}
