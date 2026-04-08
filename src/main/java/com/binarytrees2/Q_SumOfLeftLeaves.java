package main.java.com.binarytrees2;

import main.java.com.binarytrees.TreeNode;

public class Q_SumOfLeftLeaves {

    /**
     * <a href="https://leetcode.com/problems/sum-of-left-leaves/">404. Sum of Left Leaves</a>
     **/
    public int sumOfLeftLeaves(TreeNode root) {
        return returnSum(root, false);
    }

    public int returnSum(TreeNode root, boolean isLeft) {

        if (root == null)
            return 0;

        if (root.left == null && root.right == null) {
            if (isLeft)
                return root.val;
            else
                return 0;
        }

        int lSum = returnSum(root.left, true);
        int rSum = returnSum(root.right, false);

        return lSum + rSum;

    }
}
