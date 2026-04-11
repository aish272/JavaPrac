package main.java.com.binarytrees;

class rowNode {
    int row;
    TreeNode node;

    rowNode(int x, TreeNode node1) {
        this.row = x;
        this.node = node1;
    }
}

public class N_LowestCommonAncestor {

    /**
     * <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/">236. Lowest Common Ancestor of a Binary Tree</a>
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root==p||root==q)
        {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left==null)
            return right;
        if(right==null)
            return left;

        return root;


    }
}
