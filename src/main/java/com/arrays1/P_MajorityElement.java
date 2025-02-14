package main.java.com.arrays1;

public class P_MajorityElement {
    public static int majorityElement(int[] nums) {
        int max = Integer.MIN_VALUE;
        int halfOfArray = Math.floorDiv(nums.length,2);
        for(int num:nums)
        {
            if(num>max)
            {
                max = num;
            }
        }
        int[] hashArr = new int[max+1];
        for(int num: nums)
        {
            hashArr[num] = hashArr[num]+1;
        }
        for(int counter=0;counter< hashArr.length;counter++)
        {
            if(hashArr[counter]>halfOfArray)
                return counter;
        }
        return -1;
    }

    public static int majorityElementUsingMooreVoting_Optimal(int[] nums) {
        int count = 0;
        int element = 0;
        for(int num:nums)
        {
           if(count==0)
           {
               element=num;
               count++;
           }
           else if (element==num)
           {
               count++;
           }
           else
           {
               count--;
           }
        }
        /* This part is used when there is no proof that a majority element exists but in our problem statement, it is
        confirmed it does exist.

        count=0;
        for(int num:nums)
        {
            if(num==element) {
                count++;
            }
            if(count>Math.floorDiv(nums.length,2))
                return element;
        }

         */
        return element;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
}
