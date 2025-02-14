package main.java.com.arrays1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class W_MajorityElement_nBy3 {
    public static List<Integer> majorityElement(int[] nums) {
        int oneThirdOfArray = Math.floorDiv(nums.length,3);
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer,Integer> freqMap = new HashMap<>();
        for(int num:nums)
        {
            if(freqMap.containsKey(num))
            {
                freqMap.replace(num,freqMap.get(num)+1);
            }
            else
            {
                freqMap.put(num,1);
            }
        }
        freqMap.forEach((key,value)->
        {
            if(value>oneThirdOfArray)
               ans.add(key);
        });
        return ans;
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
