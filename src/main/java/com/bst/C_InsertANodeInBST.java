package main.java.com.bst;

import main.java.com.binarytrees.TreeNode;

public class C_InsertANodeInBST {

    public static TreeNode insertIntoBST(TreeNode root, int val) {

        TreeNode temp = root;
        if(root==null)
            return new TreeNode(val);
        while(temp!=null) {
            if (val > temp.val)
                if(temp.right!=null) {
                    temp = temp.right;
                }
                else
                {
                    temp.right = new TreeNode(val);
                    break;
                }
            else {
                if(temp.left!=null) {
                    temp = temp.left;
                }
                else
                {
                    temp.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        System.out.println(insertIntoBST(root, 8));
    }
}
