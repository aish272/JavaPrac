package main.java.com.graph;

import java.util.LinkedList;
import java.util.Queue;

public class F_RottenOranges {

    /**
     * <a href="https://leetcode.com/problems/rotting-oranges/">994. Rotting Oranges</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=yf3oUhkvqA0&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=10">Video solution link</a>
     */
    private static int[][] directions = {
            {-1, 0}, // Up
            {1, 0}, // Down
            {0, -1}, // Left
            {0, 1} // Right
    };

    public static int orangesRotting(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        Queue<int[]> track = new LinkedList<>();
        int freshOranges = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    track.offer(new int[]{i, j});
                    visited[i][j] = 2;
                } else {
                    visited[i][j] = 0;
                }
                if (grid[i][j] == 1)
                    freshOranges++;
            }
        }
        int time = 0;
        int rotten = 0;
        while (!track.isEmpty()) {
            int size = track.size();

            for (int counter = 0; counter < size; counter++) {
                int[] rottenCell = track.poll();
                int row = rottenCell[0];
                int cell = rottenCell[1];
                for (int dir = 0; dir < 4; dir++) {
                    int newRow = row + directions[dir][0];
                    int newCell = cell + directions[dir][1];
                    if (newRow >= 0 && newRow < grid.length && newCell < grid[0].length && newCell >= 0
                            && visited[newRow][newCell] != 2 && grid[newRow][newCell] == 1) {
                        track.offer(new int[]{newRow, newCell});
                        visited[newRow][newCell] = 2;
                        rotten++;
                    }
                }
            }
            if(!track.isEmpty())
                time++;
        }
        if (freshOranges != rotten)
            return -1;
        else
            return time;
    }

    public static void main(String[] args) {
        System.out.println(orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
    }
}
