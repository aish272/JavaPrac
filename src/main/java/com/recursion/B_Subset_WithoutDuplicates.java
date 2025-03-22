package main.java.com.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class B_Subset_WithoutDuplicates {

    public static List<List<Integer>> subsets(int[] nums) {

        HashSet<List<Integer>> ans = new HashSet<>();

        returnSubsets(ans, 0, nums,new ArrayList<>());
        return ans.stream().toList();
    }

    public static void returnSubsets(HashSet<List<Integer>> ans, int index, int[] nums,List<Integer> sub) {
        if (index == nums.length ) {
            ArrayList<Integer> temp = new ArrayList<>(sub);
            Collections.sort(temp);
            ans.add(temp);
            System.out.println(ans);
            return;
        }
        sub.add(nums[index]);
        returnSubsets(ans,index+1,nums,sub);
        sub.remove(sub.size()-1);
        returnSubsets(ans,index+1,nums,sub);

    }

    public static void main(String[] args)
    {
        System.out.println(subsets(new int[] {1,2,2}));
    }
}
