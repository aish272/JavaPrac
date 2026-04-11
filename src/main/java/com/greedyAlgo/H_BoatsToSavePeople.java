package main.java.com.greedyAlgo;

import java.util.Arrays;

public class H_BoatsToSavePeople {

    /**
     * <a href="https://leetcode.com/problems/boats-to-save-people/">881. Boats to Save People</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=UsQzOL6r0HY&t=324s">Video solution link</a>
     */
    public static int numRescueBoats(int[] people, int limit) {

        Arrays.sort(people);
        int l = 0;
        int r = people.length - 1;
        int boats = 0;
        while (l <= r) {
            if (people[l] + people[r] <= limit) {
                l++;
                r--;
            } else {
                r--;
            }
            boats++;
        }

        return boats;
    }

    public static void main(String[] args) {
        System.out.println(numRescueBoats(new int[]{3,2,3,2,2},6));

    }
}
