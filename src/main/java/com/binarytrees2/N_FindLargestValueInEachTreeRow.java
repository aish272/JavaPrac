package main.java.com.binarytrees2;

import main.java.com.binarytrees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class N_FindLargestValueInEachTreeRow {

    /**
     * <a href="https://leetcode.com/problems/find-largest-value-in-each-tree-row/">515. Find Largest Value in Each Tree Row</a>
     **/

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null)
            return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.val > max) {
                    max = node.val;
                }
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }

            }
            ans.add(max);
        }
        return ans;

    }
}
