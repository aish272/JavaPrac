package main.java.com.bst;

import main.java.com.binarytrees.TreeNode;

public class A_SearchInBST {

    public TreeNode searchBST(TreeNode root, int value) {
        if(root==null)
            return null;
        if(root.val==value)
            return root;

        return searchBST(root.val<value?root.right:root.left,value);
    }
}
