package main.java.com.llcomplete.linkedList;

public class A_LinkedList {

    public static Node convertArrToLL(int[] arr) {
        Node head = new Node(arr[0]);
        Node current = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            current.next = temp;
            current = temp;

        }
        return head;
    }

    public static int getSizeOfLL(Node ll) {
        int size = 0;
        while (ll != null) {
            size++;
            ll = ll.next;
        }
        return size;
    }

    public static void printLL(Node ll) {
        while (ll != null) {
            System.out.println(ll.data);
            ll = ll.next;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 88, 0};
        Node ll = convertArrToLL(arr);

        //Print size of ll
        System.out.println("Size: " + getSizeOfLL(ll));

        //Print all the elements of ll
        printLL(ll);
    }


}

