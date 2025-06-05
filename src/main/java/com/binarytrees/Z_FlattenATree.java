package main.java.com.binarytrees;

import java.util.Stack;

public class Z_FlattenATree {

    public void flatten(TreeNode root) {
        if(root==null)
            return;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty())
        {
            TreeNode current = s.pop();
            if(current.right!=null)
            {
                s.push(current.right);
            }
            if(current.left!=null)
            {
                s.push(current.left);
            }
            if(!s.isEmpty()) {
                current.right = s.peek();
                current.left = null;
            }
        }


    }
}
