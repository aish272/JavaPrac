package main.java.com.binarytrees;

import java.util.LinkedList;
import java.util.Queue;

public class Q_MaxWidthOfBinaryTree {

    public static int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;
        LinkedList<Integer> indexList = new LinkedList<>();
        Queue<TreeNode> nodesQ = new LinkedList<>();
        indexList.add(0);
        nodesQ.offer(root);

        while (!nodesQ.isEmpty()) {
            int sizeQ = nodesQ.size();
            LinkedList<Integer> temp = new LinkedList<>();
            for (int counter = 0; counter < sizeQ; counter++) {

                TreeNode node = nodesQ.poll();
                int min = indexList.getFirst();

                if (node.left != null) {
                    nodesQ.offer(node.left);
                    temp.add((indexList.get(counter) - min) * 2 + 1);
                }
                if (node.right != null) {
                    nodesQ.offer(node.right);
                    temp.add((indexList.get(counter) - min) * 2 + 2);
                }
            }
            maxWidth = Math.max(maxWidth, (indexList.getLast() - indexList.getFirst() + 1));
            indexList = temp;
        }
        return maxWidth;
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(9);

        // Print the result
        System.out.print(widthOfBinaryTree(root));

    }
}
