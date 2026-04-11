package main.java.com.bst;

import main.java.com.binarytrees.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Pair

{
    int start;
    int end;

    Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class O_UniqueBSTs_2 {

    /**
     * <a href="https://leetcode.com/problems/unique-binary-search-trees-ii/">95. Unique Binary Search Trees II</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=SXU--MPoUe8&t=539s">Unique Binary Search Trees II | Similar Problem | Recursion | Memoization | Amazon | Leetcode-95
     */

    public List<TreeNode> returnAllPossibleBSTs(int start, int end, Map<Pair, List<TreeNode>> dp)
    {
        List<TreeNode> rootList = new ArrayList<>();
        if(start>end)
        {
            rootList.add(null);
            return rootList;
        }
        if(dp.containsKey(new Pair(start, end)))
        {
            return dp.get(new Pair(start, end));
        }
        if(start==end)
        {
            rootList.add(new TreeNode(start));
            return rootList;

        }
        for(int i=start; i<=end; i++)
        {
            List<TreeNode> leftBSTs = returnAllPossibleBSTs( start,  i-1, dp);
            List<TreeNode> rightBSTs = returnAllPossibleBSTs( i+1,  end, dp);
            for(TreeNode leftNode: leftBSTs)
            {
                for(TreeNode rightNode: rightBSTs)
                {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    rootList.add(root);
                }
            }
        }
        dp.put(new Pair(start, end),rootList);
        return rootList;

    }

    public List<TreeNode> generateTrees(int n) {
        Map<Pair, List<TreeNode>> dp = new HashMap<>();
        return returnAllPossibleBSTs(1, n, dp);
    }


    public static void main(String[] args)
    {

    }
}
