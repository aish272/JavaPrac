package main.java.com.llcomplete.linkedList;

import static main.java.com.llcomplete.linkedList.A_LinkedList.convertArrToLL;

public class Z_MergeKSortedLists {

    /**
     * <a href="https://leetcode.com/problems/merge-k-sorted-lists/">23. Merge k Sorted Lists</a>
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        int i = 0;
        if(lists[i] == null)
            i++;
        ListNode head = lists[i];
        for ( i = i+1; i < lists.length; i++) {
            if (lists[i] == null)
                continue;
            head = mergeTwoLists(head, lists[i]);
        }
        return head;

    }

    public static ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode head;
        ListNode temp1;
        ListNode temp2;
        if (head1.val <= head2.val) {
            head = head1;
            temp1 = head1;
            temp2 = head2;
        } else {
            head = head2;
            temp1 = head2;
            temp2 = head1;
        }
        //temp1 = temp1.next;
        while (temp1.next != null) {
            ListNode temp = temp1.next;
            while (temp2 != null && temp2.val <= temp1.next.val) {

                temp1.next = temp2;
                temp2 = temp2.next;
                temp1 = temp1.next;
                temp1.next = temp;

            }
            temp1 = temp1.next;
            if (temp2 == null)
                break;
        }
        if (temp2 != null) {
            temp1.next = temp2;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 5};
        ListNode ll = convertArrToLL(arr);

        int[] arr2 = {1, 3, 4};
        ListNode ll2 = convertArrToLL(arr2);
        int[] arr3 = {2, 6};
        ListNode ll3 = convertArrToLL(arr3);

        mergeKLists(new ListNode[]{ll, ll2, ll3});
    }
}
