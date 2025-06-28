package main.java.com.graph;

public class K_NumberOfEnclave {

    /**
     * <a href="https://leetcode.com/problems/number-of-enclaves/description/">1020. Number of Enclaves</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=rxKcepXQgU4&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=15">Video solution link</a>
     */
    private static final int[][] directions = new int[][] {{0,-1},{-1,0},{1,0},{0,1}};

    public int numEnclaves(int[][] grid) {
        boolean [][] visited = new boolean[grid.length][grid[0].length];
        //traverse boundary rows(1st and last)
        for(int col = 0; col < grid[0].length; col++)
        {
            if(grid[0][col]==1 && !visited[0][col])
            {
                dfs(visited,grid,0,col);
            }
            if(grid[grid.length-1][col]==1 && !visited[grid.length-1][col])
            {
                dfs(visited,grid,grid.length-1,col);
            }
        }
        //traverse boundary cols(1st and last)
        for(int row=0;row< grid.length;row++)
        {
            if(grid[row][0]==1 && !visited[row][0])
            {
                dfs(visited,grid,row,0);
            }
            if(grid[row][grid[0].length-1]==1 && !visited[row][grid[0].length-1])
            {
                dfs(visited,grid,row,grid[0].length-1);
            }
        }

        int count=0;
        for(int row=0;row< grid.length;row++)
        {
            for(int col = 0; col < grid[0].length; col++)
            {
                if(!visited[row][col] && grid[row][col]==1)
                {
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(boolean[][] visited, int[][] grid, int row, int col)
    {
        visited[row][col] = true;
        for(int count=0;count<4;count++)
        {
            int newRow = row+ directions[count][0];
            int newCol = col+ directions[count][1];
            if(newRow>=0&&newRow<grid.length && newCol>=0 && newCol< grid[0].length &&
                !visited[newRow][newCol] && grid[newRow][newCol]==1)
            {
                dfs(visited,grid,newRow,newCol);
            }
        }
    }
}
