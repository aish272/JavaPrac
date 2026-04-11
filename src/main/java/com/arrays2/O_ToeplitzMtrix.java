package main.java.com.arrays2;

public class O_ToeplitzMtrix {

    /**
     * <a href="https://leetcode.com/problems/toeplitz-matrix/description/">766. Toeplitz Matrix</a>
     */
    public static boolean isToeplitzMatrix(int[][] matrix) {

        if(matrix.length==1 || matrix[0].length==1)
            return true;

        //row wise
        int i = 0;
        int index = 0;
        while (i < matrix.length - 1) {
            for (int j = 0; j < matrix[0].length - 1 && i < matrix.length - 1; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1])

                    return false;
                i += 1;

            }
            i = index++;
        }
        //col wise
        int j = 0;
        index = 0;
        while (j < matrix[0].length - 1) {
            for (i = 0; j < matrix[0].length - 1 && i < matrix.length - 1; i++) {
                if (matrix[i][j] != matrix[i + 1][j + 1])

                    return false;
                j += 1;

            }

            j = index++;
        }
        return true;

    }

    public static void main(String[] args)
    {
        int[][]arr = new int[][]{{97,97},{80,97},{10,80}};
        System.out.println(isToeplitzMatrix(arr));


    }
}
