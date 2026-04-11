package main.java.com.kadaneAndBS.BS1;

public class V_SearchIn2DMatrix2 {

    /**
     * <a href="https://leetcode.com/problems/search-a-2d-matrix-ii/description/">240. Search a 2D Matrix II</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=9ZbB397jU4k">Solution Video</a>
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;
        while ((col >= 0) && (row < matrix.length)) { //because we are -- the col and ++ the row;

            int num = matrix[row][col];
            if (num == target) return true;
            else if (num > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;

    }
}
