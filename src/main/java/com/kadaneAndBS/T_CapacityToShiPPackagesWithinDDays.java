package main.java.com.kadaneAndBS;

public class T_CapacityToShiPPackagesWithinDDays {

    /**
     * <a href="https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/">1011. Capacity To Ship Packages Within D Days</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=MG-Ac4TAvTY">Solution Video</a>
     */

    public int shipWithinDays(int[] weights, int days) {
        int max = Integer.MIN_VALUE; //min capacity
        int totalCap = 0; //max capacity
        for (int w : weights) {
            if (w > max)
                max = w;
            totalCap += w;
        }
        //creating new low and high vars for ease of understanding
        int low = max;
        int high = totalCap;
        int ans = 0;
        while (high >= low) {
            int mid = (low + high) / 2;
            int day = returnDaysReq(mid, weights);
            if (day <= days) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;

    }

    public int returnDaysReq(int cap, int[] weights) {
        int days = 1;
        int calculatedCap = 0;
        for (int w : weights) {
            if (calculatedCap + w <= cap) {
                calculatedCap += w;
            } else {
                days++;
                calculatedCap = w;

            }
        }
        return days;
    }
}
