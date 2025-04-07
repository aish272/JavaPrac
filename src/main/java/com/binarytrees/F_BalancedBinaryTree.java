package main.java.com.binarytrees;

public class F_BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return isBalancedReturnInt(root)!=-1;
    }

    public int isBalancedReturnInt(TreeNode root) {

        if(root==null)
            return 0;

        int lh = isBalancedReturnInt(root.left);
        if(lh==-1)
            return -1;
        int rh = isBalancedReturnInt(root.right);
        if(rh ==-1)
            return -1;
        if(Math.abs(lh-rh)>1)
            return -1;
        return Math.max(lh,rh)+1;
    }
}
