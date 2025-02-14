package main.java.com.llcomplete.linkedList;

public class I_RemoveNthNodeFromEndOfList extends A_LinkedList {


    public static void main(String[] args) {
        int[] arr = {1, 2};
        ListNode ll = convertArrToLL(arr);
        ll = removeNthFromEnd(ll,2);
        printLL(ll);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        if (head.next==null && n==1) {
            return null;
        }
        int totalNodes = 0;
        ListNode temp = head;
        while(temp!=null)
        {
            totalNodes++;
            temp = temp.next;
        }
        int targetNode = totalNodes-n;
        if(targetNode==0)
        {
            head = head.next;
            return head;
        }
        temp = head;
        while (targetNode > 1)
        {
            temp = temp.next;
            targetNode--;
        }
        if(temp.next!=null) {
            temp.next = temp.next.next;
        }
        return head;
    }

    /*
    if(head==null)
            return null;
        else if (head.next==null && n==1) {
            return null;
        }
        int totalNodes = 0;
        ListNode temp = head;
        while(temp!=null)
        {
            totalNodes++;
            temp = temp.next;
        }
        int targetNode = totalNodes-n;
        temp = head;
        while (targetNode!=1)
        {
            temp = temp.next;
            targetNode--;
        }
        if(temp.next!=null) {
            temp.next = temp.next.next;
        }
        return head;
     */


}
