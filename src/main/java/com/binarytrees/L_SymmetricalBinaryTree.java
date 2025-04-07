package main.java.com.binarytrees;

public class L_SymmetricalBinaryTree {

    public boolean isSymmetric(TreeNode root) {

        return  returnIsSymmetric(root.left,root.right) ;

    }
    public boolean returnIsSymmetric(TreeNode node1, TreeNode node2)
    {
        if(node1==null||node2==null)
            return node1==node2;
        return (node1.val == node2.val) && returnIsSymmetric(node1.left,node2.right) && returnIsSymmetric(node1.right,node2.left);
    }

}
