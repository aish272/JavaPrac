package main.java.com.graph;

public class J_SurroundedRegions {

    /**
     * <a href="https://leetcode.com/problems/surrounded-regions/description/">130. Surrounded Regions</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=BtdgAys4yMk&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=14">Video solution link</a>
     */
    private static final int [][]directions = new int[][]{{0,-1},{-1,0},{1,0},{0,1}};

    public void solve(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int row=0;row<board.length;row++)
        {
            if(board[row][0]=='O'&&!visited[row][0])
            {
                dfs(board,row,0,visited);
            }
            if(board[row][board[0].length-1]=='O'&&!visited[row][board[0].length-1])
            {
                dfs(board,row,board[0].length-1,visited);
            }
        }
        for(int col = 0; col <board[0].length; col++)
        {
            if(board[0][col]=='O'&&!visited[0][col])
            {
                dfs(board, 0,col,visited);
            }
            if(board[board.length-1][col]=='O'&&!visited[board.length-1][col])
            {
                dfs(board, board.length-1,col,visited);
            }
        }
        for(int row=0;row<board.length;row++)
        {
            for (int col=0;col<board[0].length;col++)
            {
                if(!visited[row][col]&&board[row][col]=='O')
                {
                    board[row][col]='X';
                }
            }
        }

    }

    public void dfs(char [][] board,int row, int col, boolean[][]visited)
    {
        visited[row][col]= true;
        for(int dir=0;dir<4;dir++)
        {
            int newRow = row+directions[dir][0];
            int newCol = col+directions[dir][1];
            if(newRow>=0&&newRow< board.length && newCol>=0&&newCol<board[0].length
            && !visited[newRow][newCol] && board[newRow][newCol]=='O')
            {
                dfs(board,newRow,newCol,visited);
            }
        }
    }
}
