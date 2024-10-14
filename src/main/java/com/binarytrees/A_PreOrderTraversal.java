package main.java.com.binarytrees;

import java.util.LinkedList;
import java.util.List;

public class A_PreOrderTraversal {

    List<Integer> treeValues = new LinkedList<>();
    public List<Integer> preorderTraversal(TreeNode root) {


        if(root==null)
            return null;
        treeValues.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return treeValues;

    }
}
