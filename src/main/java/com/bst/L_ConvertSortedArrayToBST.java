package main.java.com.bst;

import main.java.com.binarytrees.TreeNode;

public class L_ConvertSortedArrayToBST {

    /**
     * <a href="https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/">99. Recover Binary Search Tree</a>
     */
    public static TreeNode sortedArrayToBST(int[] nums) {
        return convert(nums, 0, nums.length - 1);
    }

    public static TreeNode convert(int[] nums, int low, int high) {
        if (high < 0 || low >= nums.length || high<low)
            return null;

        int mid = (low + high) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = convert(nums, low, mid - 1);
        root.right = convert(nums, mid + 1, high);
        return root;

    }
    public static void main(String[] args)
    {
        System.out.println(sortedArrayToBST(new int[]{-10,-3,0,5,9}));
    }
}
