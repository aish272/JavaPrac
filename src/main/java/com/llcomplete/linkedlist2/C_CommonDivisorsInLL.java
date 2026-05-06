package main.java.com.llcomplete.linkedlist2;

import main.java.com.llcomplete.linkedList.ListNode;

public class C_CommonDivisorsInLL {

    /**
     * <a href="https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list/description/">2807. Insert Greatest Common Divisors in Linked List</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=BYXcK48Bzok&list=PLpIkg8OmuX-LH398-_ZcuHiRueOdsJbXU&index=28">Video solution link</a>
     */
    public ListNode insertGreatestCommonDivisors(ListNode head) {

        if (head.next == null || head == null) {
            return head;
        }

        ListNode gcdNode = new ListNode(gcd(head.val, head.next.val));
        gcdNode.next = insertGreatestCommonDivisors(head.next);
        head.next = gcdNode;
        return head;

    }

    public int gcd(int x, int y) {
        int i;
        if (x > y) {
            i = y;
        } else {

            i = x;
        }
        for (; i >= 1; i--) {
            if (x % i == 0 && y % i == 0) {
                return i;
            }
        }
        return 1;
    }
}
