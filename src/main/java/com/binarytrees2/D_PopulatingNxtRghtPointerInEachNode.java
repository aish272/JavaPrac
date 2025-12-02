package main.java.com.binarytrees2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
public class D_PopulatingNxtRghtPointerInEachNode {

    /**
     * <a href="https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/">116. Populating Next Right Pointers in Each Node</a>
     */
    public Node connect(Node root) {
        if (root == null)
            return null;
        Queue<Node> q = new LinkedList<>();

        q.offer(root);
        List<List<Node>> nodes = new LinkedList<>();
        while (!q.isEmpty()) {
            int size = q.size();
            List<Node> l = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                Node tn = q.poll();
                if (tn.left != null) {
                    q.offer(tn.left);
                }
                if (tn.right != null) {
                    q.offer(tn.right);
                }
                l.add(tn);
            }
            nodes.add(l);
        }
        for (List<Node> l : nodes) {
            for (int i = 0; i < l.size(); i++) {
                if (i == l.size() - 1) {
                    l.get(i).next = null;
                    break;
                }
                l.get(i).next = l.get(i + 1);

            }
        }
        return root;
    }
}
