package main.java.com.bst;

import main.java.com.binarytrees.TreeNode;

public class K_RecoverBST {
    /**
     * <a href="https://leetcode.com/problems/recover-binary-search-tree/description/">99. Recover Binary Search Tree</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=ZWGW7FminDM">Video link</a>
     */
    TreeNode first = null;
    TreeNode last = null;
    TreeNode middle = null;
    TreeNode prev = null;
    public void recoverTree(TreeNode root) {
        first = last = middle = prev = null;
        findSwappedNodes(root);
        if(last!=null)
        {
            int temp = first.val;
            first.val = last.val;
            last.val=temp;
        }
        else
        {
            int temp = first.val;
            first.val = middle.val;
            middle.val=temp;
        }
    }

    public void findSwappedNodes(TreeNode root)
    {
        if(root==null)
            return;
        findSwappedNodes(root.left);
        if(prev!=null&&prev.val> root.val)
        {
            if(first==null) {
                first = prev;
                middle = root;
            }
            else
            {
                last=root;
            }
        }
        prev = root;
        findSwappedNodes(root.right);
    }
}
