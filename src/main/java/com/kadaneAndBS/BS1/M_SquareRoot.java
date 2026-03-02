package main.java.com.kadaneAndBS.BS1;

public class M_SquareRoot {

    /**
     * <a href="https://leetcode.com/problems/sqrtx/description/">69. Sqrt(x)</a>
     */
    public static int mySqrt(int x) {

        if (x == 1)
            return 1;

        int low = 0;
        int high = x / 2;
        int ans = 0;
        while (low <= high) {
            int mid = low + ((high-low) / 2);
            long result = (long) mid * mid;
            if (result == x) {
                return mid;
            } else if (result < x) {
                low = mid + 1;
                ans = mid;
            } else {
                high = mid - 1;
            }

        }
        return ans;

    }

    public static void main(String[] args)
    {
        System.out.println(mySqrt(2147395599));
    }

}
