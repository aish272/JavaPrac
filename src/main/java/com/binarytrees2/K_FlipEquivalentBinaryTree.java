package main.java.com.binarytrees2;

import main.java.com.binarytrees.TreeNode;

public class K_FlipEquivalentBinaryTree {

    /**
     * <a href="https://leetcode.com/problems/flip-equivalent-binary-trees/description/">951. Flip Equivalent Binary Trees</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=ePTZbVoJ6FI&list=PLpIkg8OmuX-K23LhcamOcDlTBisiNJy5E&index=51">Video solution link</a>
     */
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;

        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) || (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));

    }
}
