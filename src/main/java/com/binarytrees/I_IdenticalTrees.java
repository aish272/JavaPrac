package main.java.com.binarytrees;

public class I_IdenticalTrees {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null || q==null)
            return p==q;
        return p.val==q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);

    }

    public static void main(String[] args)
    {

        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        TreeNode root1 = new TreeNode(-10);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        System.out.println(isSameTree(root,root1));
    }


}
