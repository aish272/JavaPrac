package main.java.com.arrays1;

import java.util.HashMap;

public class N_2SumProblem {

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer,Integer> val = new HashMap<>();
        int[] ans = new int[2];
        for(int counter=0;counter< nums.length;counter++)
        {
            if(val.containsKey(target-nums[counter]))
            {
                ans[0] = val.get(target-nums[counter]);
                ans[1] = counter;
            }
            val.put(nums[counter],counter);
        }
        return ans;
    }
}
