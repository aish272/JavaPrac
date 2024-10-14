package main.java.com.binarytrees;

public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;
    TreeNode()
    {
        val = 0;
        left = null;
        right = null;
    }
    TreeNode (TreeNode left, TreeNode right, int val)
    {
        this.left = left;
        this.right = right;
        this.val = val;
    }
    TreeNode ( int val)
    {
        this.left = null;
        this.right = null;
        this.val = val;
    }
}
