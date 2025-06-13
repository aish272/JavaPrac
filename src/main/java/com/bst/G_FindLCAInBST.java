package main.java.com.bst;

import main.java.com.binarytrees.TreeNode;

public class G_FindLCAInBST {

    /**
     <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/">235. Lowest Common Ancestor of a Binary Search Tree</a>
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return null;
        if(root.val==p.val||root.val==q.val) //P or q is the root
            return root;
        if((p.val<root.val&& root.val< q.val)||(q.val<root.val&& root.val< p.val)) //Lowest intersection point
        {
            return root;
        }
        if((p.val<root.val&& q.val<root.val)) { //p and q both are on left
            return lowestCommonAncestor(root.left, p, q);
        }

        return lowestCommonAncestor(root.right, p, q); //p and q both are on right. Last possibility therefore removed redundant if statement
    }

    public TreeNode lcaIfElseOptimized(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return null;

        if((p.val<root.val&& q.val<root.val)) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if((p.val>root.val&& q.val>root.val)) {
            return lowestCommonAncestor(root.right, p, q);
        }
//If conditions at 27 and 30 are not true then conditions at 10 or 12 must be true
        return root;
    }
}
