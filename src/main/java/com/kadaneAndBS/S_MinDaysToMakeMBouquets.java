package main.java.com.kadaneAndBS;

public class S_MinDaysToMakeMBouquets {
    /**
     * <a href="https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/">1482. Minimum Number of Days to Make m Bouquets</a>
     * <br/>
     * <a href="https://takeuforward.org/plus/dsa/problems/minimum-days-to-make-m-bouquets?tab=editorial">TUF+ Solution Video</a>
     */
    public int minDays(int[] bloomDay, int m, int k) {

        if (bloomDay.length < (long) m * k) return -1;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int day : bloomDay) {
            if (day > high) {
                high = day;
            }
            if (day < low) {
                low = day;
            }
        }
        int ans = 0;
        while (high >= low) {
            int mid = (high + low) / 2;
            int flowerBloomed = 0;
            int bouquetMade = 0;
            for (int day : bloomDay) {
                if (day <= mid) {
                    flowerBloomed++;
                } else {
                    bouquetMade += flowerBloomed / k;
                    flowerBloomed = 0;
                }
            }
            bouquetMade += flowerBloomed / k;
            flowerBloomed = 0;
            if (bouquetMade >= m) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;

    }

}
