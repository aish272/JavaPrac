package main.java.com.binarytrees;

import java.util.LinkedList;
import java.util.List;

public class C_PostorderTraversal {
    static List<Integer> treeNodes = new LinkedList<>();
    public static List<Integer> postorderTraversal(TreeNode root) {
        if(root==null)
            return treeNodes;

        postorderTraversal(root.left);
        postorderTraversal(root.right);
        treeNodes.add(root.val);
        return treeNodes;
    }

    public static void main(String[] args)
    {
        TreeNode rightL = new TreeNode(4);
        TreeNode rightR = new TreeNode(5);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(rightL,rightR,3);
        TreeNode root = new TreeNode(left,right,1);
        postorderTraversal(root);
      }
}
