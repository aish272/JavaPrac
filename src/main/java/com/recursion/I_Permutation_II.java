package main.java.com.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class I_Permutation_II {

    /**
     * <a href="https://leetcode.com/problems/permutations-ii/">47. Permutations II</a>
     */


    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> numList = new ArrayList<>();
        Set<List<Integer>> ans = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            numList.add(nums[i]);
        }
        createAllPermutations(ans, new ArrayList<>(), numList);
        return ans.stream().toList();
    }

    public void createAllPermutations(Set<List<Integer>> ans, List<Integer> combo, List<Integer> numList) {
        if (numList.size() == 0) {
            ans.add(new ArrayList<>(combo));
            return;
        }
        for (int i = 0; i < numList.size(); i++) {
            int num = numList.get(0);
            combo.add(num);
            numList.remove(0);
            createAllPermutations(ans, combo, numList);
            combo.remove(combo.size() - 1);
            numList.add(num);
        }

    }
}
