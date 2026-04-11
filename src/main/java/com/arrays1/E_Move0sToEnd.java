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
    public static void moveZeroes1(int[] nums) {
        int lastZero  = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0&&nums[lastZero]!=0) {
                lastZero = i;
            }
            if(nums[i]!=0 &&nums[lastZero]==0)
            {
                nums[lastZero] = nums[i];
                nums[i] =0;
                lastZero++;
            }

        }
        for(int num:nums)
        {
            System.out.print(num+" ");
        }
    }

    public static void mov0ToEnd(int[] arr)
    {
        int i =0;
        int j =0;
        while(j<arr.length)
        {
            if(arr[i]==0&&arr[j]!=0)
            {
                arr[i] = arr[j];
                arr[j] = 0;
                i++;
            }
            if(arr[i]!=0)
            {
                i++;
            }
            j++;
        }

    }

    public static void main(String args[]) {
        mov0ToEnd(new int[]{1,0,2,0,3,0,4,0,5,0});
    }
}
