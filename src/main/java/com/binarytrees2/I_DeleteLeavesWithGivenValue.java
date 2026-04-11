package main.java.com.binarytrees2;

import main.java.com.binarytrees.TreeNode;

public class I_DeleteLeavesWithGivenValue {

    /**
     * <a href="https://leetcode.com/problems/delete-leaves-with-a-given-value/">1325. Delete Leaves With a Given Value</a>
     **/
    public TreeNode removeLeafNodes(TreeNode root, int target) {

        if (root == null) return null;

        if (root.val == target && root.left == null && root.right == null) {
            return null;
        }

        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);

        if (root.val == target && root.left == null && root.right == null) return null;

        else return root;

    }
}
