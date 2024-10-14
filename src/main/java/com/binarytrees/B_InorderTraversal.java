package main.java.com.binarytrees;

import java.util.LinkedList;
import java.util.List;

public class B_InorderTraversal {
    static List<Integer> treeNodes = new LinkedList<>();
    public static List<Integer> inorderTraversal(TreeNode root) {
        if(root==null)
            return treeNodes;
        inorderTraversal(root.left);

        treeNodes.add(root.val);
        inorderTraversal(root.right);
        return treeNodes;
    }

    public static void main(String[] args)
    {
        TreeNode rightL = new TreeNode(4);
        TreeNode rightR = new TreeNode(5);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(rightL,rightR,3);
        TreeNode root = new TreeNode(left,right,1);
        inorderTraversal(root);
      }
}
