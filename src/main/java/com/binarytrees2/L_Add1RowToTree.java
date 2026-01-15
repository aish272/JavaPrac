package main.java.com.binarytrees2;

import main.java.com.binarytrees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class L_Add1RowToTree {

    /**
     * <a href="https://leetcode.com/problems/add-one-row-to-tree/description/">623. Add One Row to Tree</a>
     **/

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode root1 = new TreeNode(val);
            root1.left = root;
            return root1;
        }
        int level = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (level == depth - 2) {

                    TreeNode l = node.left;
                    node.left = new TreeNode(val);
                    node.left.left = l;

                    TreeNode r = node.right;
                    node.right = new TreeNode(val);
                    node.right.right = r;

                } else {
                    if (node.left != null) {
                        q.offer(node.left);

                    }
                    if (node.right != null) {

                        q.offer(node.right);

                    }
                }
            }
            if (level == depth - 2)
                return root;
            level++;
        }
        return root;

    }
}
