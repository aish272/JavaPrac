package main.java.com.bst;

import main.java.com.binarytrees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class F_CheckIfTreeIsBST {

    public static boolean isValidBST(TreeNode root) {
        return returnSortedListUsingInorderTraversal(root,new ArrayList<>());
    }

    public static boolean returnSortedListUsingInorderTraversal(TreeNode root, List<Integer>sortedList)
    {
        if(root==null)
            return true;
        boolean leftRslt = returnSortedListUsingInorderTraversal(root.left,sortedList);
        if(sortedList.size()>0)
        {
            if( sortedList.get(sortedList.size()-1)>root.val)
                return false;
        }
        sortedList.add(root.val);
        boolean rightRslt = returnSortedListUsingInorderTraversal(root.right,sortedList);
        return leftRslt && rightRslt;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        System.out.println(isValidBST(root));

    }
}
