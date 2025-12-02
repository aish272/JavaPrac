package main.java.com.binarytrees2;

import main.java.com.binarytrees.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class A_LevelOrderTraversal2 {

    /**
     * <a href="https://leetcode.com/problems/binary-tree-level-order-traversal-ii">107. Binary Tree Level Order Traversal II</a>
     */

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null)
            return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> sublist = new LinkedList<>();
            int childNodes = q.size();
            for (int i = 0; i < childNodes; i++) {
                TreeNode node = q.poll();
                sublist.add(node.val);
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }

            }
            ans.add(sublist);
        }

        for (int i = 0; i < ans.size() / 2; i++) {
            int size = ans.size();
            List<Integer> frontSublist = ans.get(i);
            List<Integer> backSublist = ans.get(size-i-1);
            ans.add(i, backSublist);
            ans.remove( i+1);
            ans.add(size- 1 - i, frontSublist);
            ans.remove(size-i);



        }
        return ans;

    }

    public static void main(String[] args)
    {

        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode leftL = new TreeNode(3);
        TreeNode left4 = new TreeNode(4);
        TreeNode left5 = new TreeNode(5);

        root.left = left;
        left.left = leftL;
        leftL.left = left4;
        left4.left = left5;
        System.out.println(levelOrderBottom(root));
    }
}
