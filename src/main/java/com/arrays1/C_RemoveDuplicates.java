package main.java.com.arrays1;

import java.util.Stack;

public class C_RemoveDuplicates {


    public static int removeDuplicates(int[] nums) {

        Stack<Integer> s = new Stack<>();
        s.push(nums[0]);
        for(int i = 1;i<nums.length;i++)
        {
            if(s.peek()!=nums[i])
            {
                s.push(nums[i]);
            }
        }
        for(int i = 0;i<s.size();i++)
        {
            nums[i] = s.get(i);
        }

        return s.size();

    }
    public static int removeDuplicatesOptimal_Using2pointer(int[] nums) {

        int tracker = 0;
        for(int iterator = 1; iterator <nums.length; iterator++)
        {
            if(nums[tracker]!=nums[iterator])
            {
                tracker++;
                nums[tracker] = nums[iterator];
            }
        }
        return tracker+1;

    }

    public static void main(String args[])

    {
        System.out.println(removeDuplicates(new int[]{1,1,2}));
        System.out.println(removeDuplicatesOptimal_Using2pointer(new int[]{1,1,2}));
    }
}
