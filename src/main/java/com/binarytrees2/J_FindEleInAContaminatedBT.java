package main.java.com.binarytrees2;

import main.java.com.binarytrees.TreeNode;

public class J_FindEleInAContaminatedBT {
}

/**
 * <a href="https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/">1261. Find Elements in a Contaminated Binary Tree</a>
 **/
class FindElements {

    TreeNode root;

    public FindElements(TreeNode root) {
        this.root = recover(root, 0);
    }

    public TreeNode recover(TreeNode root, int val) {
        if (root == null) return null;

        root.val = val;
        recover(root.left, val * 2 + 1);
        recover(root.right, val * 2 + 2);
        return root;

    }

    public boolean find(int target) {

        return preOrder(root, target);

    }

    public boolean preOrder(TreeNode root, int target) {
        if (root == null) return false;
        if (root.val == target) return true;

        return preOrder(root.left, target) || preOrder(root.right, target);
    }
}
