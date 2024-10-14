package main.java.com.binarytrees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class D_LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrderedVals = new LinkedList<>();
        Queue<TreeNode> treeNodesQ = new LinkedList<>();
        if(root==null)
            return levelOrderedVals;
        treeNodesQ.offer(root);
        while (!treeNodesQ.isEmpty())
        {
            int childNodes = treeNodesQ.size();
            List<Integer> subList = new LinkedList<>();
            for(int i=0;i<childNodes;i++)
            {
                TreeNode  child = treeNodesQ.poll();
                if(child.left!=null)
                    treeNodesQ.offer(child.left);
                if(child.right!=null)
                    treeNodesQ.offer(child.right);
                subList.add(child.val);
            }
            levelOrderedVals.add(subList);
        }

        return levelOrderedVals;
    }

    public static void main(String[] args)
    {


    }
}
