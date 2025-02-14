package main.java.com.arrays1;

public class  B_CheckArrayIsSortedAndRotated{


    public static boolean check(int[] nums) {
        int index = 0;
        while (index<nums.length-1)
        {
            if(nums[index]> nums[index+1])
            {
                break;
            }
            index ++;
        }
        int lastNum = nums[index];
        if(lastNum == nums[nums.length-1])
        {
            return true;
        }
        index += 1;
        while (index<nums.length-1)
        {
            if(nums[index]>nums[index+1])
                return false;
            index++;
        }
        return lastNum >= nums[nums.length-1] && nums[0] >= nums[nums.length-1];
    }

    public static void main(String args[])
    {
        System.out.println(check(new int[]{2,4,1,3}));
    }
}
