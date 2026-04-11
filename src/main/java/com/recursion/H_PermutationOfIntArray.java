package main.java.com.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class H_PermutationOfIntArray {

    /**
     * <a href="https://leetcode.com/problems/permutations/description/">46. Permutations</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=YK78FU5Ffjw&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=51">Video link Approach 1</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=f2ic2Rsc9pU&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=53">Video link Approach 2 without extra space</a>
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> track = new Stack<>();
        for(int num:nums)
            track.add(num);
        createPermutations(track,ans,new ArrayList<>());
        return ans;

    }
    public static void createPermutations(List<Integer> track, List<List<Integer>> ans,List<Integer>combo)
    {
        if(track.isEmpty())
        {
            ans.add(new ArrayList<>(combo));
        }
        int size= track.size();
        for (int count=0;count<size;count++)
        {
            int ele = track.remove(0);
            combo.add(ele);
            createPermutations(track,ans,combo);
            track.add(ele);
            combo.remove(combo.size()-1);
        }
    }
    public static List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permutationsWithoutSpace(new ArrayList<>(),ans,0,nums);
        return ans;

    }
    public static void permutationsWithoutSpace(List<Integer> combo, List<List<Integer>> ans, int index, int[] nums)
    {
        if(index==nums.length)
        {
            ans.add(new ArrayList<>(combo));
            return;
        }
        for (int count=index;count<nums.length;count++)
        {
            int temp = nums[index];
            nums[index] = nums[count];
            nums[count] = temp;
            combo.add(nums[index]);
            permutationsWithoutSpace(combo,ans,index+1,nums);
            combo.remove(combo.size()-1);
            temp = nums[count];
            nums[count]= nums[index];
            nums[index] = temp;
        }
    }
    public static void main(String[] args) {
        System.out.println(permute1(new int[]{1,2,3}));

    }
}
