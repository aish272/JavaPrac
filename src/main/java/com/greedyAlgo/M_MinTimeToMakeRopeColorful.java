package main.java.com.greedyAlgo;

public class M_MinTimeToMakeRopeColorful {

    /**
     * <a href="https://leetcode.com/problems/minimum-time-to-make-rope-colorful/">1578. Minimum Time to Make Rope Colorful</a>
     */
    public int minCost(String colors, int[] neededTime) {

        int index = 0;
        int time = 0;
        while (index < colors.length() - 1) {
            if (colors.charAt(index) == colors.charAt(index + 1)) {

                time += Math.min(neededTime[index], neededTime[index + 1]);
                //neededTime[index+1] value balloon has been removed, so next comparion should be done with value at neededTime[index]
                if (neededTime[index] > neededTime[index + 1]) {
                    neededTime[index + 1] = neededTime[index];
                }
            }
            index++;
        }
        return time;

    }
}
