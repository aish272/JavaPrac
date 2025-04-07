package main.java.com.binarytrees;

import java.util.*;

class Tuple1
{
    int row;
    TreeNode node;
    Tuple1(int x, TreeNode node1)
    {
        this.row = x;
        this.node = node1;
    }
}

public class M_TopViewOfBT {

    static ArrayList<Integer> topView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null)
            return ans;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<rowNode> queueWithTuple = new LinkedList<>();
        queueWithTuple.offer(new rowNode(0,root));
        while (!queueWithTuple.isEmpty())
        {
            rowNode tuple = queueWithTuple.poll();
            TreeNode node  = tuple.node;
            int row = tuple.row;
            if(!map.containsKey(row))
            {
                map.put(row,node.val);
            }
            if(node.left!=null)
            {
                queueWithTuple.offer(new rowNode(row-1,node.left));
            }
            if(node.right!=null)
            {
                queueWithTuple.offer(new rowNode(row+1,node.right));
            }
        }

            ans.addAll(map.values());

        return ans;


    }
    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(10);
        root.right.left = new TreeNode(9);


        // Get the Vertical traversal
        List<Integer> topView = topView(root);

        // Print the result
        System.out.print(topView);

    }
}
