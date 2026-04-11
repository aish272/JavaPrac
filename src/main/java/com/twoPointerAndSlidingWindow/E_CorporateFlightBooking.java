package main.java.com.twoPointerAndSlidingWindow;

public class E_CorporateFlightBooking {

    /**
     * <a href="https://leetcode.com/problems/corporate-flight-bookings/">1109. Corporate Flight Bookings</a>
     */

    public int[] corpFlightBookings(int[][] bookings, int n) {

        int[] ans = new int[n];
        for (int[] booking : bookings) {
            for (int i = booking[0]; i <= booking[1]; i++) {
                ans[i - 1] += booking[2];
            }
        }
        return ans;

    }
}
