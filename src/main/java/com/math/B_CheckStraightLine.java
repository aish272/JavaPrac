package main.java.com.math;

public class B_CheckStraightLine {

    /**
     * <a href="https://leetcode.com/problems/check-if-it-is-a-straight-line/description/">1232. Check If It Is a Straight Line</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=ZG2ZYd7U03s&list=PLpIkg8OmuX-Js_8KIvsQskF7-RvCGg4nr&index=7">Video Solution</a>
     */

    public boolean checkStraightLine(int[][] coordinates) {

        /**
         x2 - x1
         m = ---------
         y2 - y1
         */

        int delX = coordinates[1][0] - coordinates[0][0];
        int delY = coordinates[1][1] - coordinates[0][1];

        for (int i = 2; i < coordinates.length; i++) {

            int delXi = coordinates[i][0] - coordinates[0][0];
            int delYi = coordinates[i][1] - coordinates[0][1];
            if (delX * delYi != delXi * delY) {
                return false;
            }
        }
        return true;

    }
}
