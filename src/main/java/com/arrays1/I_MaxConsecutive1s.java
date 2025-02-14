package main.java.com.arrays1;

public class I_MaxConsecutive1s {


    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int currentCount = 0;
        for(int num:nums)
        {
            if(num==1)
            {
                currentCount++;
            }
            else
            {
                currentCount =0;
            }
            if(maxCount<currentCount)
            {
                maxCount = currentCount;
            }
        }



        return maxCount;
    }

    public static void main(String[] args) {
    }

}
