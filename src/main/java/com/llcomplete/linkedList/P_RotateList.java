package main.java.com.llcomplete.linkedList;

import static main.java.com.llcomplete.linkedList.A_LinkedList.convertArrToLL;
import static main.java.com.llcomplete.linkedList.A_LinkedList.printLL;

public class P_RotateList {
    /**
     * <a href="https://leetcode.com/problems/rotate-list/">61. Rotate List</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=9VPm6nEbVPA&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=40">Video solution link</a>
     */

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int length = 0;
        ListNode last = null;
        ListNode current = head;
        ListNode current1 = head;
        while (current != null) {
            last = current;
            current = current.next;
            length++;
        }
        int actualRotation = k % length;
        int count = 1;
        current = head;
        while (count < (length - actualRotation)) {

            current = current.next;
            count++;

        }
        ListNode temp = current.next;
        current.next = null;
        head = temp;
        last.next = current1;

        return head;

    }
    public static void main(String[] args) {
        int[] arr = {0,1,2};
        ListNode ll = convertArrToLL(arr);
        printLL(rotateRight(ll,4));

    }
}
