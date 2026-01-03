package main.java.com.twoPointerAndSlidingWindow;

public class N_CountSubarrWhereMaxEleAppearKTime {

    /**
     * <a href="https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/description/">2962. Count Subarrays Where Max Element Appears at Least K Times</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=06VaWkj8e-0&list=PLpIkg8OmuX-J2Ivo9YdY7bRDstPPTVGvN&index=18">Video solution link</a>
     */
    public static long countSubarrays(int[] nums, int k) {

        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (max < num) {
                max = num;
            }
        }
        long count = 0;
        int freq = 0;

        int l = 0;
        int r = 0;
        int n = nums.length;
        while (r < n) {
            while (r < n && freq < k) {
                if (nums[r] == max) {
                    freq++;

                }
                if(freq<k) {
                    r++;
                }
            }


            count += n - r;
            l++;
            if (nums[l - 1] == max) {
                freq--;
                r++;
                while (r < n && nums[r] != max) {
                    r++;
                }
                freq++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[]{1, 3, 2, 3, 3}, 2));

    }
}
