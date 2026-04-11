package main.java.com.binarytrees;

import java.util.LinkedList;
import java.util.Queue;

public class V_CountNodesInCompleteTree {

    public int countNodes(TreeNode root) {
        int nodes =0;
        Queue<TreeNode> nodesQ = new LinkedList<>();
        if(root!=null)
            nodesQ.offer(root);
        while (!nodesQ.isEmpty())
        {
            TreeNode node = nodesQ.poll();
            if(node.left!=null)
                nodesQ.offer(node.left);
            if(node.right!=null)
                nodesQ.offer(node.right);
            nodes++;

        }


        return nodes;
    }
}
