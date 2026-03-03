package main.java.com.llcomplete.linkedlist2;

import main.java.com.llcomplete.linkedList.ListNode;

public class B_MergeInBetweenLL {

    /**
     * <a href="https://leetcode.com/problems/merge-in-between-linked-lists/">1669. Merge In Between Linked Lists</a>
     **/
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        ListNode beforeNodeA = null;
        ListNode afterNodeB = null;
        ListNode temp = list1;
        int index = 0;
        while (index <= b) {
            if (index == a - 1) {
                beforeNodeA = temp;
            }
            temp = temp.next;
            index++;
        }
        afterNodeB = temp;
        beforeNodeA.next = list2;
        temp = list2;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = afterNodeB;
        return list1;

    }
}
