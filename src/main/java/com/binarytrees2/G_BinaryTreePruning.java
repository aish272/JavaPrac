package main.java.com.binarytrees2;

import main.java.com.binarytrees.TreeNode;

public class G_BinaryTreePruning {

    /**
     * <a href="https://leetcode.com/problems/binary-tree-pruning/">814. Binary Tree Pruning</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=vV5oRkBWHo4&list=PLpIkg8OmuX-K23LhcamOcDlTBisiNJy5E&index=10">Video solution link</a>
     */
    public TreeNode pruneTree(TreeNode root) {
        return dfs(root);
    }

    public TreeNode dfs(TreeNode root)

    {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null && root.val != 1) {
            return null;
        }

        root.left = dfs(root.left);
        root.right = dfs(root.right);
        if (root.left == null && root.right == null && root.val != 1) {
            return null;
        }
        return root;
    }
}
