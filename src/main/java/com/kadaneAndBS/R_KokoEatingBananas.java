package main.java.com.kadaneAndBS;

public class R_KokoEatingBananas {
    /**
     * <a href="https://leetcode.com/problems/koko-eating-bananas/description/">875. Koko Eating Bananas</a>
     * <br/>
     * <a href="https://takeuforward.org/plus/dsa/problems/koko-eating-bananas?tab=editorial">TUF+ Solution Video</a>
     */
    public int minEatingSpeed(int[] piles, int h) {

        int max = Integer.MIN_VALUE;
        for (int num : piles) {
            if (num > max) {
                max = num;
            }
        }
        long low = 1;
        long high = max;
        long mid = 0;
        long ans = 0;
        while (high >= low) {
            mid = (low + high) / 2;
            long hr = 0;
            for (long pile : piles) {
                hr += Math.ceilDiv(pile, mid);
            }
            if (hr <= h) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int) ans;

    }
}
