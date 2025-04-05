package main.java.com.binarytrees;

import java.util.*;

public class J_ZigZagTraversal {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        if(root==null)
            return ans;
        Queue<TreeNode> nodesQ = new LinkedList<>();

        nodesQ.offer(root);
        boolean leftToRight = true;
        while(!nodesQ.isEmpty())
        {
            int sizeOfQueue = nodesQ.size(); //this is necessary because size of queue increases after adding left and right node.
            List<Integer> subAns = new ArrayList<>(sizeOfQueue);
            for(int counter = 0; counter <sizeOfQueue; counter++)
            {
                TreeNode node = nodesQ.poll();
                subAns.add(node.val);
                if(node.left!=null) {
                    nodesQ.add(node.left);
                }
                if(node.right!=null) {
                    nodesQ.add(node.right);
                }
            }
            if(leftToRight)
            {
                ans.add(subAns);
            }
            else
            {
                Collections.reverse(subAns);
                ans.add(subAns);
            }
            leftToRight = !leftToRight;
        }
        return ans;

    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(zigzagLevelOrder(root));
    }

}
