package main.java.com.kadaneAndBS.BS1;

public class Q_SearchIn2DMatrix {

    /**
     * <a href="https://leetcode.com/problems/search-a-2d-matrix/description">74. Search a 2D Matrix</a>
     */

    public static boolean searchMatrix(int[][] matrix, int target) {

        int high = (matrix.length * matrix[0].length)-1;
        int low = 0;
        while(high>=low)
        {
            int mid = (high+low)/2;
            int row = mid/matrix[0].length;
            int col = mid%matrix[0].length ;

            if(matrix[row][col]==target)
            {
                return true;
            }
            else if(matrix[row][col]<target)
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }

        }
        return false;

    }

    public static void main(String [] args)
    {
        int[][] arr = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(searchMatrix(arr,3));

    }
}
