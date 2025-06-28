package main.java.com.graph;

import java.util.LinkedList;
import java.util.Queue;

class Pair
{
    int row;
    int col;

    Pair(int row, int col)
    {
        this.row = row;
        this.col = col;
    }
}

public class D_NumberOfIslands {

    /**
     * <a href="https://leetcode.com/problems/number-of-islands/">200. Number of Islands</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=muncqlKJrH0&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=8">Video solution link</a>
     */
    public int numIslands(char[][] grid) {

        int row=grid.length;
        int col = grid[0].length;

        boolean[][] visited = new boolean [row][col];
        int numOfIslands =0;
        for(int i=0;i<row;i++) {
            for (int j = i; j<col; j++)
            {
                if(!visited[i][j]&&grid[i][j]=='1')
                {
                    numOfIslands++;
                    bfsOnMatrix(i,j,visited,grid);
                }
            }
        }
        return numOfIslands;

    }

    public void bfsOnMatrix(int row,int col,boolean[][] visited,char[][] grid)
    {
        int m = grid.length;
        int n = grid[0].length;
        visited[row][col] = true;
        Queue<Pair> pairQueue = new LinkedList<>();
        pairQueue.offer(new Pair(row, col));
        while (!pairQueue.isEmpty()) {
            Pair temp = pairQueue.poll();
            row = temp.row;
            col = temp.col;
            int[][] directions = {
                    { -1, 0 }, // Up
                    { 1, 0 }, // Down
                    { 0, -1 }, // Left
                    { 0, 1 } // Right
            };
            for (int[] dir : directions) {
                int r = dir[0] + row;
                int c = dir[1] + col;
                if (r >= 0 && r < m && c >= 0 && c < n &&
                        !visited[r][c] && grid[r][c] == '1') {
                    visited[r][c] = true;
                    pairQueue.offer(new Pair(r, c));
                }

            }
        }
    }
}
