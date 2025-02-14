package main.java.com.llcomplete.linkedList;

public class D_MiddleOfLL extends A_LinkedList {

    public static ListNode findTheMidOfLLBruteForce(ListNode head)
    {
        ListNode ll = head;
        int size = 0;
        while (ll != null) {
            size++;
            ll = ll.next;
        }
        if(size == 1)
        {
            return head;
        }
        int mid = (size/2) +1;
        ll = head;
        int counter =1;
        while(counter<mid)
        {
            ll = ll.next;
            counter++;
        }
        return ll;
    }

    public static void main(String[] args)
    {
        int[] arr = {9,8} ;
        ListNode head = convertArrToLL(arr);
        ListNode mid = findTheMidOfLLBruteForce(head);
        printLL(mid);
    }


}
