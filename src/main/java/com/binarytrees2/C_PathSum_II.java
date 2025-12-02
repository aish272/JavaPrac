package main.java.com.binarytrees2;

import main.java.com.binarytrees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class C_PathSum_II {

    /**
     * <a href="https://leetcode.com/problems/path-sum-ii">113. Path Sum II</a>
     */

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        returnPaths(root, targetSum, new ArrayList<>(), 0, ans);
        return ans;
    }

    public static void returnPaths(TreeNode root, int targetSum, List<Integer> subList, int sum, List<List<Integer>> ans) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            sum += root.val;
            subList.add(root.val);
            if (sum == targetSum) {

                ans.add(new ArrayList<>(subList));
            }
            return;

        }
        subList.add(root.val);
        sum += root.val;
        returnPaths(root.left, targetSum, subList, sum, ans);
        if (root.left != null) {

            subList.remove(subList.size() - 1);
        }

        returnPaths(root.right, targetSum, subList, sum, ans);
        if (root.right != null) {
            subList.remove(subList.size() - 1);
        }


    }

    public static void main(String[] args) {


        TreeNode leftLL = new TreeNode(7);
        TreeNode leftLR = new TreeNode(2);
        TreeNode leftL = new TreeNode(leftLL, leftLR, 11);
        TreeNode left = new TreeNode(leftL, null, 4);
        TreeNode rightL = new TreeNode(13);
        TreeNode rightRL = new TreeNode(5);
        TreeNode rightRR = new TreeNode(1);
        TreeNode rightR = new TreeNode(rightRL,rightRR,4);
        TreeNode right = new TreeNode(rightL,rightR,8);
        TreeNode root = new TreeNode(left, right, 5);

        System.out.println(pathSum(root, 22));
    }
}
