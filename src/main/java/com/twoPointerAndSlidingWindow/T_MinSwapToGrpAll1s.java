package main.java.com.twoPointerAndSlidingWindow;

public class T_MinSwapToGrpAll1s {

    /**
     * <a href="https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together-ii/description/">2134. Minimum Swaps to Group All 1's Together II</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=t82KJaI1kNQ&list=PLpIkg8OmuX-J2Ivo9YdY7bRDstPPTVGvN&index=25">Video solution link</a>
     */
    public static int minSwaps(int[] nums) {
        int longestCluster = 0;
        int total1s = 0;
        int cluster = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                total1s++;
            }
        }
        int l = 0;
        int r = 0;
        for (; r < total1s; ) {
            if (nums[r] == 1) {
                cluster++;
                longestCluster = Math.max(longestCluster, cluster);
            }

            r++;
        }
        r--;
        while (l < nums.length) {
            if (nums[l] == 1)
                cluster--;
            l++;
            r++;
            if (r == nums.length)
                r = 0;
            if (nums[r] == 1)
                cluster++;

            longestCluster = Math.max(longestCluster, cluster);

        }

        return total1s - longestCluster;

    }

    public static void main(String[] args)
    {
        minSwaps(new int[]{0,1,1,1,0,0,1,1,0});
    }
}
