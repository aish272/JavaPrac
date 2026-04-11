package main.java.com.arrays2;

public class L_MaxProdOf2ElementInArray {

    /**
     * <a href="https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/">1464. Maximum Product of Two Elements in an Array</a>
     */
    public int maxProduct(int[] nums) {

        int max = Integer.MIN_VALUE;
        int max1 = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max) {
                max1 = max;
                max = num;

            } else if (num > max1) {
                max1 = num;
            }
        }
        return (max1 - 1) * (max - 1);

    }
}
