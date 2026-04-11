package main.java.com.binarytrees2;

import main.java.com.binarytrees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class E_CheckCompletenessOfBT {

    /**
     * <a href="https://leetcode.com/problems/check-completeness-of-a-binary-tree/">958. Check Completeness of a Binary Tree</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=08e5EBHoXxE&t=514s">Video solution link</a>
     */
    public boolean isCompleteTree(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node != null) {
                    q.offer(node.left);
                    q.offer(node.right);
                } else {
                    while (!q.isEmpty()) {
                        TreeNode node1 = q.poll();
                        if (node1 != null) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;

    }

}
