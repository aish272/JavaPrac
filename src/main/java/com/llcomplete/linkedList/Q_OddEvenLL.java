package main.java.com.llcomplete.linkedList;

import static main.java.com.llcomplete.linkedList.A_LinkedList.convertArrToLL;
import static main.java.com.llcomplete.linkedList.A_LinkedList.printLL;

public class Q_OddEvenLL {

    /**
     * <a href="https://leetcode.com/problems/odd-even-linked-list/description/">328. Odd Even Linked List</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=qf6qp7GzD5Q">Video solution link</a>
     */
    public static ListNode oddEvenList(ListNode head) {
        ListNode temp = head;
        ListNode oddStart = new ListNode();
        ListNode oddTrack = oddStart;
        ListNode evenStart = new ListNode();
        ListNode evenTrack = evenStart;

        int count=1;
        while(temp!=null)
        {
            if(count%2==1) {
                oddTrack.next = temp;
                oddTrack = oddTrack.next;
            }
            if(count%2==0) {
                evenTrack.next = temp;
                evenTrack = evenTrack.next;
            }
            temp = temp.next;
            count++;
        }
        evenTrack.next = null;
        oddTrack.next = evenStart.next;
        return oddStart.next;

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        ListNode ll = convertArrToLL(arr);
        printLL(oddEvenList(ll));

    }
}
