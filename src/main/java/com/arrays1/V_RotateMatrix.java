package main.java.com.arrays1;

import java.util.Arrays;

public class V_RotateMatrix {
    public static int[][] rotate(int[][] matrix) {

        int temp1;
        int temp2;
        int n = matrix.length;
        for(int row = 0; row< n /2; row++)
        {
            for(int column=row;column<= n-2-row;column++)
            {
                int r1 = row;
                int c1 = column;
                int r2 = c1;
                int c2 = n-1-r1;
                temp1 = matrix[r1][c1];
                for(int corner=0;corner<4;corner++)
                {
                    temp2 = matrix[r2][c2];
                    matrix[r2][c2] = temp1;
                    r1 = r2;
                    c1 = c2;
                    r2 = c1;
                    c2 = n-1-r1;
                    temp1 = temp2;
                }
            }
        }
        return matrix;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(rotate(new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}})));
        System.out.println(Arrays.deepToString(rotate(new int[][]{{1,2,3}, {4,5,6}, {7,8,9}})));
    }
}
