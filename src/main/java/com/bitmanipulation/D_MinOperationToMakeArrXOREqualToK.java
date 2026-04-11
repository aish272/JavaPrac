package main.java.com.bitmanipulation;

public class D_MinOperationToMakeArrXOREqualToK {

    /**
     * <a href="https://leetcode.com/problems/minimum-number-of-operations-to-make-array-xor-equal-to-k/">2997. Minimum Number of Operations to Make Array XOR Equal to K</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=rZYdNpHXz0o&list=PLpIkg8OmuX-I-t2eiSxfO0UjiLhmNGfon&index=18">Video solution link</a>
     */
    public int minOperations(int[] nums, int k) {

        int totalXor = 0;
        for (int num : nums) {
            totalXor ^= num;
        }
        int diff = totalXor ^ k;
        int oneCount = 0;
        while (diff > 1) {
            if (diff % 2 == 1) {
                oneCount++;
            }
            diff /= 2;
        }
        if (diff == 1) {

            oneCount++;
        }
        return oneCount;

    }
}
