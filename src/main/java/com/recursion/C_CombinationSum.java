package main.java.com.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class C_CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        HashSet<List<Integer>> ans = new HashSet<>();
        findCombinationSum(ans, 0,new ArrayList<>(),candidates,target,0);
        return ans.stream().toList();
    }

    public void findCombinationSum(HashSet<List<Integer>> ans, int index, List<Integer> subset, int[] candidateArr, int target, int sum)
    {
        if(sum==target)
        {
            ans.add(new ArrayList<>(subset));
            return;
        }
        else if (index==candidateArr.length || sum>target)
        {
            return;
        }
        sum += candidateArr[index];
        subset.add(candidateArr[index]);
        findCombinationSum(ans, index, subset, candidateArr, target, sum);
        subset.remove(subset.size()-1);
        sum -= candidateArr[index];
        findCombinationSum(ans,index+1,subset,candidateArr,target,sum);
    }

    public static void main(String[] args)
    {
        System.out.println();
    }
}
