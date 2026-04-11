package main.java.com.arrays2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class K_SingleNumber3 {

    /**
     * <a href="https://leetcode.com/problems/single-number-iii/description/">260. Single Number III</a>
     */

    public static int[] singleNumber(int[] nums) {

        Map<Integer, Integer> hash = new HashMap<>();
        for (int num : nums) {
            hash.put(num, hash.getOrDefault(num, 0) + 1);
        }
        int[] ans = new int[2];
        int index = 0;
        for(Map.Entry<Integer,Integer> ele : hash.entrySet())
        {

            if(ele.getValue()==1)
            {
                ans[index] = ele.getKey();
                index++;
            }
        }
        return ans;

    }
    public static void main(String[] args)
    {
        int[]arr = new int[]{1,2,1,3,2,5};
        System.out.println(Arrays.toString(singleNumber(arr)));


    }
}
