package main.java.com.bst;

import main.java.com.binarytrees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class J_TwoSumInBST {

    /**
     * <a href="https://leetcode.com/problems/two-sum-iv-input-is-a-bst/">653. Two Sum IV - Input is a BST</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=ssL3sHwPeb4">Video link</a>
     */
    public static boolean findTarget(TreeNode root, int k) {
        return findOutIfSumExists(root, k,new ArrayList<>());
    }

    public static boolean findOutIfSumExists(TreeNode root, int k, List<Integer> sortedList)
    {
        if(root==null)
            return false;

        boolean left =findOutIfSumExists(root.left,k,sortedList);
        if(sortedList.contains(k- root.val))
            return true;
        sortedList.add(root.val);
        boolean right =findOutIfSumExists(root.right, k,sortedList);
        return left||right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(findTarget(root,3));

    }
}
