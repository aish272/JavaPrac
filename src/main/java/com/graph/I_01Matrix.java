package main.java.com.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class I_01Matrix {

    /**
     * <a href="https://leetcode.com/problems/01-matrix/">542. 01 Matrix</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=edXdVwkYHF8">Video solution link</a>
     */

    private static final int[][] directions = {
            {-1, 0}, // Up
            {1, 0}, // Down
            {0, -1}, // Left
            {0, 1} // Right
    };

    public int[][] updateMatrix(int[][] mat) {

        int[][] ans = new int[mat.length][mat[0].length];
        for(int[] arr:ans) {
            Arrays.fill(arr, -1);
        }
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        Queue<int[]> track = new LinkedList<>();
        for(int row=0;row<mat.length;row++)
        {
            for(int col = 0; col <mat.length; col++) {
                if (mat[row][col]==0)
                {
                   visited[row][col]=true;
                   track.offer(new int[]{row,col});
                }
            }
        }
        int dist=0;
        while (!track.isEmpty())
        {
            int size = track.size();
            for(int count=0;count<size;count++)
            {
                int[] pair = track.poll();
                ans[pair[0]][pair[1]] = dist;
                for(int dir=0;dir<4;dir++)
                {
                    int newRow = directions[dir][0]+pair[0];
                    int newCol = directions[dir][1]+pair[1];
                    if(newRow>=0&&newRow< mat.length&&newCol>=0&&newCol< mat[0].length
                     && !visited[newRow][newCol])
                    {
                        track.offer(new int[]{newRow,newCol});
                        visited[newRow][newCol]=true;
                    }
                }
            }
            dist++;
        }
        return ans;

    }
}
