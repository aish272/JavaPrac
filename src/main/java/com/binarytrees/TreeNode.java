package main.java.com.binarytrees;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode()
    {
        val = 0;
        left = null;
        right = null;
    }
    public TreeNode (TreeNode left, TreeNode right, int val)
    {
        this.left = left;
        this.right = right;
        this.val = val;
    }
    public TreeNode ( int val)
    {
        this.left = null;
        this.right = null;
        this.val = val;
    }
}
