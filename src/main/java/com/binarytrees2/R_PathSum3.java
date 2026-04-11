package main.java.com.binarytrees2;

import main.java.com.binarytrees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class R_PathSum3 {

    /**
     * <a href="https://leetcode.com/problems/path-sum-iii/">437. Path Sum III</a>
     **/
    public static int pathSum(TreeNode root, int targetSum) {
        return returnTotalPathSum(root, targetSum, new ArrayList<Long>());
    }

    public static int returnTotalPathSum(TreeNode root, int targetSum, List<Long> paths) {

        if (root == null)
            return 0;

        int pathFound = 0;

        for (int i = 0; i < paths.size(); i++) {
            long num = paths.get(i) + root.val;
            if (num == targetSum) {
                pathFound++;
            }
            paths.remove(i);
            paths.add(i, num);
        }
        if (targetSum == root.val) {
            pathFound++;
        }
        paths.add((long) root.val);

        int leftPath = returnTotalPathSum(root.left, targetSum, paths);
        if (root.left != null) {
            for (int i = 0; i < paths.size(); i++) {
                long num = paths.get(i) - root.left.val;
                paths.remove(i);
                paths.add(i, num);
            }
            paths.remove(paths.size() - 1);
        }

        int rightPath = returnTotalPathSum(root.right, targetSum, paths);
        if (root.right != null) {
            for (int i = 0; i < paths.size(); i++) {
                long num = paths.get(i) - root.right.val;
                paths.remove(i);
                paths.add(i, num);
            }
            paths.remove(paths.size() - 1);
        }

        return pathFound + leftPath + rightPath;

    }

    public static void main(String[] args) {


        TreeNode leftLL = new TreeNode(3);
        TreeNode leftLR = new TreeNode(-2);
        TreeNode leftL = new TreeNode(leftLL, leftLR, 3);
        TreeNode leftRR = new TreeNode(null, null, 1);
        TreeNode leftR = new TreeNode(null, leftRR, 2);
        TreeNode left = new TreeNode(leftL, leftR, 5);
        TreeNode rightR = new TreeNode(null,null,11);
        TreeNode right = new TreeNode(null,rightR,-3);
        TreeNode root = new TreeNode(left, right, 10);

        System.out.println(pathSum(root, 8));
    }
}
