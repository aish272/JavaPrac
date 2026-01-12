package main.java.com.llcomplete.linkedList;

import main.java.com.binarytrees.TreeNode;

import static main.java.com.llcomplete.linkedList.A_LinkedList.convertArrToLL;

public class Y_LinkedListInBinaryTree {

    /**
     * <a href="https://leetcode.com/problems/linked-list-in-binary-tree/">1367. Linked List in Binary Tree</a>
     */
    public static boolean isSubPath(ListNode head, TreeNode root) {

        if (root == null) {
            return false;
        }

        if (root.val == head.val) {
            if (findPath(head.next, root))
                return true;
        }
        return isSubPath(head, root.left) || isSubPath(head, root.right);

    }

    public static boolean findPath(ListNode temp, TreeNode root) {
        if (temp == null) {
            return true;
        }

        if (root.left != null && temp.val == root.left.val) {
            if (findPath(temp.next, root.left))
                return true;

        }
        if (root.right != null && temp.val == root.right.val) {
            return findPath(temp.next, root.right);
        }

        return false;

    }

    public static void main(String[] args) {
        int[] arr = {1,4,2,6};
        ListNode ll = convertArrToLL(arr);
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(6);
        root.right.left.right = new TreeNode(8);
        root.right.left.right.left = new TreeNode(1);
        root.right.left.right.right = new TreeNode(3);
        isSubPath(ll,root);

    }
}
