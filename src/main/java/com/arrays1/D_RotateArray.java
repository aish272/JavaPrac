package main.java.com.arrays1;

public class D_RotateArray {


    public static int[] rotate(int[] nums, int k) {
        int prev = nums[0];
        while (k!=0)
        {
            for(int counter=1;counter<nums.length;counter++)
            {
               int toBeShifted = nums[counter];
               nums[counter] = prev;
               prev = toBeShifted;
            }
            nums[0] = prev;
            k--;
        }
        return nums;

    }

    public static void rotateOptimal(int[] nums, int k) {
        int[] temp = new int[k];
        int length = nums.length;
        for(int counter =length-k;counter<nums.length;counter++)
        {
            temp[counter- (length-k)] = nums[counter];
        }

        for(int counter=k-1;counter>=0;counter--)
        {
             nums[counter+k]=nums[counter];
        }

        for(int counter=0;counter<k;counter++)
        {
            nums[counter] = temp[counter];
        }

        for(int num : nums)
        {
            System.out.print(num+" ");
        }


    }

    public static void main(String args[])
    {
        //System.out.println(rotate(new int[]{2,4,1,3,9,0},1));
        rotateOptimal(new int[]{1,2,3,4,5,6,7},3);

    }
}
