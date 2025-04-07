package main.java.com.binarytrees;

public class H_MaxPathSum {

    public static int maxPathSum(TreeNode root) {
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        calculateMaxPathSum(root,maxSum);
        return maxSum[0];
    }

    public static int calculateMaxPathSum(TreeNode root, int[] maxSum) {
        if (root == null)
            return 0;
        int lSum = calculateMaxPathSum(root.left, maxSum);
        int rSum = calculateMaxPathSum(root.right, maxSum);
        int sum = root.val + Math.max(lSum ,rSum);
        maxSum[0] = Math.max(maxSum[0], sum);
        return sum;
    }

    public static void main(String[] args)
    {

        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(maxPathSum(root));
    }
}
