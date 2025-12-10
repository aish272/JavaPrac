package main.java.com.kadaneAndBS;

public class W_FindPeakEleIn2DMatrix2 {

    /**
     * <a href="https://leetcode.com/problems/find-a-peak-element-ii/description/">1901. Find a Peak Element II</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=nGGp5XBzC4g">Solution Video</a>
     */
    public int[] findPeakGrid(int[][] mat) {

        int low = 0;
        int high = mat[0].length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int max = Integer.MIN_VALUE;
            int row = 0;
            for (int i = 0; i < mat.length; i++) {
                if (max < mat[i][mid]) {
                    max = mat[i][mid];
                    row = i;
                }
            }
            int left = mid - 1 >= 0 ? mat[row][mid - 1] : -1;
            int right = mid + 1 < mat[0].length ? mat[row][mid + 1] : -1;
            int num = mat[row][mid];
            if (left < num && num > right) {
                return new int[]{row, mid};
            } else if (left > num) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[]{-1, -1};

    }
}
