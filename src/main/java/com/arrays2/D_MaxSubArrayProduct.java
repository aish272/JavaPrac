package main.java.com.arrays2;

public class D_MaxSubArrayProduct {
    public int maxProductUsingModifiedKadane(int[] nums) {
        int rightProduct = 1;
        int leftProd = 1;
        int ans = Integer.MIN_VALUE;
        for(int index=0;index<nums.length;index++)
        {
            if(leftProd==0) {
                leftProd = 1;
            }
            if(rightProduct==0) {
                rightProduct = 1;
            }
            leftProd *= nums[index];
            rightProduct *= nums[nums.length-1-index];

            int max = Math.max(leftProd,rightProduct);
            ans = Math.max(max,ans);
        }
        return ans;

    }
}
