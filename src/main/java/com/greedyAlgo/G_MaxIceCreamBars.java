package main.java.com.greedyAlgo;

import java.util.Arrays;

public class G_MaxIceCreamBars {

    /**
     * <a href="https://leetcode.com/problems/maximum-ice-cream-bars/">1833. Maximum Ice Cream Bars</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=uY3mWwJvRkA&list=PLpIkg8OmuX-J8_n8Vy9P9I3KvyDcPMzRU&index=11">Video solution link</a>
     */
    public int maxIceCream(int[] costs, int coins) {

        Arrays.sort(costs);
        int bought = 0;
        for (int cost : costs) {
            if (coins < cost) {
                break;
            } else {
                coins -= cost;
                bought++;
            }
        }
        return bought;

    }
}
