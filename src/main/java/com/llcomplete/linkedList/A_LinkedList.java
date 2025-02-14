package main.java.com.llcomplete.linkedList;

public class A_LinkedList {

    public static ListNode convertArrToLL(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode temp = new ListNode(arr[i]);
            current.next = temp;
            current = temp;

        }
        return head;
    }

    public static int getSizeOfLL(ListNode ll) {
        int size = 0;
        while (ll != null) {
            size++;
            ll = ll.next;
        }
        return size;
    }

    public static void printLL(ListNode ll) {
        while (ll != null) {
            System.out.println(ll.data);
            ll = ll.next;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 88, 0};
        ListNode ll = convertArrToLL(arr);

        //Print size of ll
        System.out.println("Size: " + getSizeOfLL(ll));

        //Print all the elements of ll
        printLL(ll);
    }


}

