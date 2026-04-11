package main.java.com.llcomplete.linkedList;

public class O_Sort2LL {

    /**
     * <a href="https://leetcode.com/problems/sort-list/description/">148. Sort List</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=8ocB7a_c-Cc">Video solution link</a>
     */

    public ListNode sortList(ListNode head) {

        return sortLL(head);
    }

    public ListNode sortLL(ListNode node)
    {
        if(node==null||node.next==null)
            return node;
        ListNode mid = findMiddle(node);
        ListNode right = mid.next;
        mid.next = null;//separating left from right list;
        ListNode left = node;
        left=sortLL(left);
        right= sortLL(right);
        return merge2SortedLists(left,right);
    }
    public static ListNode  merge2SortedLists(ListNode leftNode, ListNode rightNode)
    {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while (leftNode!=null&&rightNode!=null) {
            if (leftNode.val < rightNode.val) {
                temp.next = leftNode;
                leftNode = leftNode.next;
            } else {
                temp.next = rightNode;
                rightNode = rightNode.next;
            }
            temp = temp.next;
        }
        while(leftNode!=null)
        {
            temp.next = leftNode;
            leftNode=leftNode.next;
            temp = temp.next;

        }
        while(rightNode!=null)
        {
            temp.next = rightNode;
            rightNode=rightNode.next;
            temp = temp.next;

        }
        return dummy.next;
    }
    public ListNode findMiddle(ListNode node)
    {
        ListNode fast = node;
        ListNode slow = node;
        fast = fast.next;
        while (fast!=null&&fast.next!=null)
        {
            fast=fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
