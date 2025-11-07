package main.java.com.arrays2;

import java.util.*;

public class I_SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {

        int[][] visited = new int[matrix.length][matrix[0].length];
        int row = 0;
        int col = 0;
        List<Integer> ans = new ArrayList<>();
        ans.add(matrix[row][col]);
        visited[row][col]=1;
        for (int counter = 1; counter < matrix.length * matrix[0].length;) {
            while (col < matrix[0].length - 1) {
                col++;
                if (visited[row][col] == 0) {
                    ans.add(matrix[row][col]);
                    visited[row][col] = 1;
                    counter++;
                } else {
                    col--;
                    break;
                }

            }

            while (row < matrix.length - 1 ) {
                row++;
                if (visited[row][col] == 0) {
                    ans.add(matrix[row][col]);
                    visited[row][col] = 1;
                    counter++;
                } else {
                    row--;
                    break;
                }

            }

            while (col > 0 ) {
                col--;
                if (visited[row][col] == 0) {
                    ans.add(matrix[row][col]);
                    visited[row][col] = 1;
                    counter++;
                } else {
                    col++;
                    break;
                }

            }

            while (row > 0) {
                row--;
                if (visited[row][col] == 0) {
                    ans.add(matrix[row][col]);
                    visited[row][col] = 1;
                    counter++;
                } else {
                    row++;
                    break;
                }

            }


        }
        return ans;

    }

    public static void main(String[] args)
    {
        int[][]arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(arr));


    }
}
