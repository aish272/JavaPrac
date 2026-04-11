package main.java.com.twoPointerAndSlidingWindow;

public class S_BrokenCalculator {

    /**
     * <a href="https://leetcode.com/problems/broken-calculator/">991. Broken Calculator</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=svM2wbyMT4g&list=PLpIkg8OmuX-J8_n8Vy9P9I3KvyDcPMzRU&index=4">Video solution link</a>
     */
    public int brokenCalc(int startValue, int target) {
        int op = 0;
        while (target != startValue) {
            if (target > startValue) {
                if (target % 2 == 0) {
                    target /= 2;
                    op += 1;
                } else {
                    target += 1; //make target an even integer
                    target /= 2;
                    op += 2;
                }
            } else {
                op += startValue - target;
                target += (startValue - target);
            }
        }
        return op;

    }
}
