package main.java.com.bst;

import main.java.com.binarytrees.TreeNode;
import main.java.com.llcomplete.linkedList.ListNode;

public class O_ConvertSortedLLToBST {

    /**
     * <a href="https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree">109. Convert Sorted List to Binary Search Tree</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=4zvmruet_H0">Convert Sorted List to Binary Search Tree | Google | Flipkart | Amazon | Leetcode 109</a>
     */

    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)
            return null;

        if(head.next==null)
            return new TreeNode ( head.val);

        ListNode slow = head;
        ListNode fast = head;
        ListNode slowPrev = null;
        while(fast!=null && fast.next!=null)
        {
            slowPrev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        slowPrev.next = null;
        TreeNode root = new TreeNode (slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
}
