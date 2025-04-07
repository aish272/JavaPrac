package main.java.com.binarytrees;

import java.util.*;

class Tuple
{
    int row;
    int col;
    TreeNode node;
    Tuple(int x, int y, TreeNode node1)
    {
        this.row = x;
        this.col = y;
        this.node = node1;
    }
}

public class K_VerticalOrderTraversal {

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
        Queue<Tuple> nodeQWithXAndY = new LinkedList<>();
        nodeQWithXAndY.offer(new Tuple(0,0,root));
        while(!nodeQWithXAndY.isEmpty())
        {
            Tuple tup = nodeQWithXAndY.poll();
            int verticalOrder = tup.row;
            int widthOrder = tup.col;
            if(!map.containsKey(verticalOrder))
            {
                map.put(verticalOrder, new TreeMap<>());
            }
            if(!map.get(verticalOrder).containsKey(widthOrder))
            {
                map.get(verticalOrder).put(widthOrder,new LinkedList<>());
            }
            map.get(verticalOrder).get(widthOrder).add(tup.node.val);
            if(tup.node.left!=null)
            {
                nodeQWithXAndY.offer(new Tuple(verticalOrder-1,widthOrder+1,tup.node.left));
            }
            if(tup.node.right!=null)
            {
                nodeQWithXAndY.offer(new Tuple(verticalOrder+1,widthOrder+1,tup.node.right));
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(TreeMap<Integer,List<Integer>> tree: map.values())
        {
            List<Integer> colSortedWRTWidth = new ArrayList<>();

            for(List<Integer> queueWithVals: tree.values())
            {
                List<Integer> col = new LinkedList<>(queueWithVals);
                Collections.sort(col);
                colSortedWRTWidth.addAll(col);
            }

            ans.add(colSortedWRTWidth);
        }
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
        List<List<Integer>> verticalTraversal = verticalTraversal(root);

        // Print the result
        System.out.print(verticalTraversal);

    }
}
