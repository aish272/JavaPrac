package main.java.com.dp;

import java.util.Arrays;
import java.util.List;

public class L_TriangleMinPathSum {

    public int minimumTotal(List<List<Integer>> triangle) {
        return returnMinTotal(0, 0, triangle);
    }

    public static int returnMinTotal(int indexOfSublist, int indexOfList, List<List<Integer>> triangle) {
        if (indexOfList == triangle.size() - 1)
            return triangle.get(indexOfList).get(indexOfSublist);
        int left = triangle.get(indexOfList).get(indexOfSublist)
                + returnMinTotal(indexOfSublist, indexOfList + 1, triangle);
        int right = triangle.get(indexOfList).get(indexOfSublist)
                + returnMinTotal(indexOfSublist + 1, indexOfList + 1, triangle);
        return (Math.min(left, right));
    }

    public static int minimumTotalDp(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        for(int[] arr:dp)
        {
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        return returnMinTotalDp(0,0,triangle,dp);
    }

    public static int returnMinTotalDp(int indexOfSublist, int indexOfList,List<List<Integer>> triangle, int [][] dp )
    {
        if(indexOfList==triangle.size()-1)
            return triangle.get(indexOfList).get(indexOfSublist);
        if(dp[indexOfList][indexOfSublist]!=Integer.MAX_VALUE)
            return dp[indexOfList][indexOfSublist];
        int left =  triangle.get(indexOfList).get(indexOfSublist) + returnMinTotalDp(indexOfSublist,indexOfList+1,triangle,dp);
        int right =  triangle.get(indexOfList).get(indexOfSublist) + returnMinTotalDp(indexOfSublist+1,indexOfList+1,triangle,dp);
        return dp[indexOfList][indexOfSublist]=(Math.min(left,right));
    }

    public static void main(String[] args) {
        // Define the points for each activity on each day
        List<List<Integer>> triangle = List.of(List.of(2),List.of(3,4),List.of(6,5,7),List.of(4,1,8,3));
        System.out.println( minimumTotalDp(triangle));
    }
}
