package main.java.com.arrays1;

public class E_Move0sToEnd {


    public static void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {


            if (nums[j] == 0 && nums[i] != 0) {
                nums[j] = nums[i];
                j++;
                nums[i] = 0;
            }
            if(nums[i]==0 && nums[j]!=0)
            {
                j = i;
            }
        }
        for(int num:nums)
        {
            System.out.print(num+" ");
        }
    }

    public static void main(String args[]) {
        moveZeroes(new int[]{0,1,0,3,12});
    }
}
