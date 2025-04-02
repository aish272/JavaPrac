package main.java.com.dp;

import java.util.Arrays;

public class G_NinjaTraining {

    public static int maximumPoints(int arr[][]) {
        int[][] dp = new int[arr.length][4];
        return returnMaxPoints(arr.length-1, arr,3,dp);
    }
    public static int returnMaxPoints(int day, int arr[][], int taskAlreadyDone, int[][] dp)
    {
        if(dp[day][taskAlreadyDone]!=0)
            return dp[day][taskAlreadyDone];
          if(day ==0)
          {
              int max = Integer.MIN_VALUE;
              for(int counter=0;counter<=2;counter++)
              {
                  if(counter!=taskAlreadyDone)
                  {
                      max = Math.max(max,arr[day][counter]);
                  }
              }
              return dp[day][taskAlreadyDone]=max;
          }
          int maxPoints = Integer.MIN_VALUE;
        for(int counter=0;counter<=2;counter++)
        {
            if(counter!=taskAlreadyDone)
            {
                int points = arr[day][counter]+returnMaxPoints(day -1,arr,counter,dp);
                if(points>maxPoints) {
                    maxPoints = points;
                }
            }
        }
        return dp[day][taskAlreadyDone]=maxPoints;
    }

    public static int maximumPointsTab(int points[][]) {
        int n = points.length;
        int[][] dp = new int[n][4];

        // Initialize the first day's maximum points based on the available choices
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        // Iterate through each day and each activity
        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0; // Initialize the maximum points for the current day and last activity
                // Consider each possible task for the current day
                for (int task = 0; task <= 2; task++) {
                    if (task != last) { // Ensure that the current task is different from the last
                        // Calculate the points for the current activity and add it to the maximum points from the previous day
                        int activity = points[day][task] + dp[day - 1][task];
                        // Update the maximum points for the current day and last activity
                        dp[day][last] = Math.max(dp[day][last], activity);
                    }
                }

            }
            System.out.println(Arrays.toString(dp[day]));

        }

        // Return the maximum points achievable after all days (last activity is 3)
        return dp[n - 1][3];
    }

    public static int maximumPointsTabSpaceOptimized(int points[][]) {
        int n = points.length;
        int[] dp = new int[4];
        dp[0] = Math.max(points[0][1], points[0][2]);
        dp[1] = Math.max(points[0][0], points[0][2]);
        dp[2] = Math.max(points[0][0], points[0][1]);
        dp[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));
        for (int day = 1; day < n; day++) {
            int[] temp = new int[4];
            for (int last = 0; last < 4; last++) {
                for (int task = 0; task <= 2; task++) {
                    if (task != last) {
                        int activity = points[day][task] + dp[task];
                        temp[last] = Math.max(temp[last], activity);
                    }
                }
            }
            dp[0] = temp[0];
            dp[1] = temp[1];
            dp[2] = temp[2];
            dp[3] = temp[3];
        }
        return dp[3];
    }
    public static void main(String args[]) {
        // Define the points for each activity on each day
        int[][] points = {{10, 40, 70},
                {20, 50, 80},
                {30, 60, 90}};
        System.out.println(maximumPointsTabSpaceOptimized(points)); // Calculate and print the maximum points
    }
}
