package main.java.com.arrays1;

import java.util.*;

public class X_3Sum {
    public List<List<Integer>> threeSumBetter(int[] nums) {

        Set<List<Integer>> uniqueTriplets = new HashSet<>();
        for(int i=0; i<nums.length-2;i++)
        {
            Set<Integer> thirdEle = new HashSet<>();
            for(int j=i+1; j<nums.length;j++)
            {
                if(thirdEle.contains(-(nums[i]+nums[j])))
                {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], -(nums[i]+nums[j]));
                    temp.sort(null);
                    uniqueTriplets.add(temp);
                }
                thirdEle.add(nums[j]);
            }
        }
        return new ArrayList<>(uniqueTriplets);
    }

    public List<List<Integer>> threeSumOptimal(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++)
        {
            if(i>0&&nums[i]==nums[i-1])
                continue;
            int j= i+1;
            int k = nums.length-1;
            while(j<k)
            {
                int sum = nums[i]+nums[j]+nums[k];
                if(sum>0)
                {
                    k--;
                }
                else if(sum<0)
                {
                    j++;
                }
                else
                {
                   ans.add(List.of(nums[i],nums[j],nums[k]));
                   j++;
                   k--;
                   while(j<k && nums[j]==nums[j-1])
                       j++;
                   while(j<k && nums[k]==nums[k+1])
                       k--;
                }

            }
        }
        return ans;
    }
}
