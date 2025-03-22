package main.java.com.recursion;

import java.util.*;

public class D_CombinationSum_II {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        HashSet<List<Integer>> ans = new HashSet<>();
        findCombinationSum(ans, 0,new ArrayList<>(),candidates,target,0);
        return ans.stream().toList();
    }

    public static void findCombinationSum(HashSet<List<Integer>> ans, int index, List<Integer> subset, int[] candidateArr, int target, int sum)
    {
        if(sum==target)
        {
            List<Integer> temp =  new ArrayList<>(subset);
            Collections.sort(temp);
            ans.add(new ArrayList<>(temp));
            return;
        }
        else if (index==candidateArr.length || sum>target)
        {
            return;
        }
        sum += candidateArr[index];
        subset.add(candidateArr[index]);
        findCombinationSum(ans, index+1, subset, candidateArr, target, sum);
        subset.remove(subset.size()-1);
        sum -= candidateArr[index];
        findCombinationSum(ans,index+1,subset,candidateArr,target,sum);
    }

    public static List<List<Integer>> combinationSum2optimised(int[] candidates, int target) {
        HashSet<List<Integer>> ans = new HashSet<>();
        Arrays.sort(candidates);
        findCombinationSumOptimised(ans, 0,new ArrayList<>(),candidates,target,0);
        return ans.stream().toList();
    }

    public static void findCombinationSumOptimised(HashSet<List<Integer>> ans, int index, List<Integer> subset, int[] candidateArr, int target, int sum)
    {
        for(int i=index;i<=candidateArr.length;i++)
        {
            if(sum==target)
            {
                ans.add(new ArrayList<>(subset));
                return;
            }
            else if (sum>target || i== candidateArr.length)
            {
                return;
            }
            if(i==index || candidateArr[i]!=candidateArr[i-1]) {
                sum += candidateArr[i];
                subset.add(candidateArr[i]);
                findCombinationSumOptimised(ans, i + 1, subset, candidateArr, target, sum);
                sum -= candidateArr[i];
                subset.remove(subset.size()-1);
            }

        }
    }

    public static void main(String[] args)
    {
        System.out.println(combinationSum2optimised(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1, 1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},30));
    }
}
