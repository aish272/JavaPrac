package main.java.com.recursion;

import java.util.ArrayList;
import java.util.List;

public class A_Subset {

    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> subss = new ArrayList<>();
        returnSubsets(ans, 0, nums,subss );
        return ans;
    }

    public static void returnSubsets(List<List<Integer>> ans, int index, int[] nums,ArrayList<Integer> sub) {
        if (index == nums.length ) {
            ans.add(new ArrayList<>(sub));
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
        System.out.println(subsets(new int[] {1,2,3}));
    }
}
