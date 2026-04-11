package main.java.com.recursion;

public class K_WordSearch {

    /**
     * <a href="https://leetcode.com/problems/word-search/">79. Word Search</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=whyax_vB8xY&list=PLpIkg8OmuX-KJPC18SGiRUzJQAYo839ox">Video solution link</a>
     */
    private static int[][] directions = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };

    public static boolean exist(char[][] board, String word) {

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == word.charAt(0)) {
                    if (dfs(new StringBuilder(), board, word, row, col, 0)) {
                        return true;
                    }

                }
            }
        }
        return false;

    }

    public static boolean dfs(StringBuilder s, char[][] board, String word, int row, int col, int ind) {

        if (s.length() == word.length()) {
            return s.toString().equals(word);
        }
        if ((row < 0 || row >= board.length) || (col < 0 || col >= board[0].length)
                || (board[row][col] == '$' || board[row][col] != word.charAt(ind))) {
            return false;
        }

        s.append(board[row][col]);
        ind += 1;
        char og = board[row][col];
        board[row][col] = '$'; //visited
        for (int[] dir : directions) {
            if (dfs(s, board, word, row + dir[0], col + dir[1], ind))
                return true;
        }
        s.deleteCharAt(s.length()-1);
        board[row][col] = og;
        return false;

    }

    public static void main(String[] args)
    {
        System.out.println(exist(new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}},"ABCESEEEFS"));
    }
}
