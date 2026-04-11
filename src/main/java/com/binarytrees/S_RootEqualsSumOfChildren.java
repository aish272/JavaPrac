package main.java.com.binarytrees;

public class S_RootEqualsSumOfChildren {

    public boolean checkTree(TreeNode root) {

        return root.left.val+root.right.val == root.val;

    }
}
