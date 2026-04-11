package main.java.com.binarytrees;

import java.util.LinkedList;
import java.util.Queue;

public class R_FindBottomLeftTreeValue {

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        int val =0;
        nodeQueue.offer(root);
        while(!nodeQueue.isEmpty())
        {
            int sizeQ = nodeQueue.size();
            for(int counter =0;counter<sizeQ;counter++)
            {
                TreeNode node = nodeQueue.poll();
                if(counter==0) {
                    val = node.val;
                }
                if(node.left!=null)
                    nodeQueue.offer(node.left);
                if(node.right!=null)
                    nodeQueue.offer(node.right);
            }
        }
        return val;
    }
}
