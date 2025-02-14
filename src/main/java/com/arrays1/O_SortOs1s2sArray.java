package main.java.com.arrays1;

public class O_SortOs1s2sArray {
    public void sortColors(int[] nums) {
        int numOfZeros =0;
        int numOf1s =0;

        for (int num : nums) {
            if (num == 0) {
                numOfZeros++;
            } else if (num == 1) {
                numOf1s++;
            }
        }
        for(int counter =0;counter<nums.length;counter++)
        {
            if(numOfZeros>0)
            {
                nums[counter] =0;
                numOfZeros--;
            }
            else if (numOf1s>0)
            {
                nums[counter] =1;
                numOf1s--;
            }
            else
            {
                nums[counter] =2;
            }
        }
    }
}
