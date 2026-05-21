package main.java.com.binarytrees2;

import main.java.com.binarytrees.TreeNode;

import java.util.*;

public class S_MinNumOfOpsToSortBTByLevel {

    /**
     * <a href="https://leetcode.com/problems/minimum-number-of-operations-to-sort-a-binary-tree-by-level/description/">2471. Minimum Number of Operations to Sort a Binary Tree by Level</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=u_IE2W_FEPk&list=PLpIkg8OmuX-K23LhcamOcDlTBisiNJy5E&index=54">Video solution link</a>
     */
    public static int minimumOperations(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        if (root == null || (root.left == null && root.right == null)) return 0;
        q.offer(root);
        int swaps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> sortedLevel = new ArrayList<>();
            List<Integer> level = new ArrayList<>();
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < size; i++) {
                TreeNode child = q.poll();
                map.put(child.val, i);
                sortedLevel.add(child.val);
                level.add(child.val);
                if (child.left != null) {
                    q.offer(child.left);
                }
                if (child.right != null) {
                    q.offer(child.right);
                }
            }
            Collections.sort(sortedLevel);
            for (int i = 0; i < size; i++) {
                int nodeVal = sortedLevel.get(i);
                System.out.println(map.get(nodeVal));
                if (map.get(nodeVal) != i) //index of node in map is not same as sorted list's index
                {
                    // System.out.println(nodeVal);
                    int ind = map.get(nodeVal);
                    map.put(nodeVal, i); // map with index according to sorted list;
                    int toBeSwapped = level.get(i);
                    map.put(toBeSwapped, ind);
                    //rearrange level according to the swap done in map.
                    level.remove(i);
                    level.add(i, nodeVal);
                    level.remove(ind);
                    level.add(ind, toBeSwapped);
                    swaps++;
                }

            }

        }
        return swaps;

    }

    public static void main(String[] args) {


        TreeNode leftLL = new TreeNode(27);
        TreeNode leftL = new TreeNode(leftLL, null, 20);
        TreeNode leftR = new TreeNode(null, null, 46);
        TreeNode left = new TreeNode(leftL, leftR, 45);
        TreeNode rightLL = new TreeNode(25);
        TreeNode rightL = new TreeNode(rightLL, null, 15);
        TreeNode rightR = new TreeNode(null, null, 39);
        TreeNode right = new TreeNode(rightL, rightR, 1);
        TreeNode root = new TreeNode(left, right, 49);

        System.out.println(minimumOperations(root));
    }
}
