package main.java.com.binarytrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

class rowNode {
    int row;
    TreeNode node;

    rowNode(int x, TreeNode node1) {
        this.row = x;
        this.node = node1;
    }
}

public class N_LowestCommonAncestor {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

//        TreeMap<Integer, LinkedList<Integer>> map1 = findPath(root,p);
//        TreeMap<Integer, LinkedList<Integer>> map2 = findPath(root,q);
//        while (!map1.isEmpty()||!map2.isEmpty())
//        {
//            map1.get(map1.firstKey()).stream().
//        }
        if(root==null||root==p||root==q)
        {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left==null)
            return right;
        if(right==null)
            return left;

        return root;


    }


    public TreeMap<Integer, LinkedList<Integer>> findPath(TreeNode root, TreeNode pathToFind) {

        TreeMap<Integer, LinkedList<Integer>> map = new TreeMap<>();
            Queue<rowNode> queueWithTuple = new LinkedList<>();
            queueWithTuple.offer(new rowNode(0, root));
            while (!queueWithTuple.isEmpty()) {
                rowNode tuple = queueWithTuple.poll();
                TreeNode node = tuple.node;
                int row = tuple.row;
                if (!map.containsKey(row)) {
                    map.put(row, new LinkedList<>());
                }
                map.get(row).add(node.val);
                if (node.val == pathToFind.val) return map;
                if (node.left != null) {
                    queueWithTuple.offer(new rowNode(row - 1, node.left));
                }
                if (node.right != null) {
                    queueWithTuple.offer(new rowNode(row + 1, node.right));
                }
            }
        return map;
    }
}
