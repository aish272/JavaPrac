package main.java.com.arrays1;

public class U_SetMatrixZeros {
    public void setZeroesBrute(int[][] matrix) {

        int[] rowMarkedArray = new int[matrix.length];
        int[] colMarkedArray = new int[matrix[0].length];

        for(int row=0;row< matrix.length;row++)
        {
            for(int col=0;col< matrix[0].length;col++)
            {
                if(matrix[row][col]==0)
                {
                    rowMarkedArray[row]=1;
                    colMarkedArray[col]=1;
                }
            }
        }
        for(int i =0;i< rowMarkedArray.length;i++)
        {
            for(int j =0;j< colMarkedArray.length;j++)
            {
                if(rowMarkedArray[i]==1 || colMarkedArray[j]==1)
                {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
