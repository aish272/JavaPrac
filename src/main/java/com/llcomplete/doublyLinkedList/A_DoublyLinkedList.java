package main.java.com.llcomplete.doublyLinkedList;

class Node
{
    Node next;
    Node prev;
    int data;

    Node(Node next, Node prev, int data)
    {
        this.next = next;
        this.prev = prev;
        this.data = data;
    }
}
public class A_DoublyLinkedList {

    public static Node convertArrayToDLL(int[] arr)
    {
        Node head = new Node(null,null, arr[0]);
        Node current = head;
        for(int i=1; i<arr.length;i++)
        {
            Node temp = new Node(null, current,arr[i]);
            current.next = temp;
            current = temp;
        }
        return head;
    }

    public static void printDLL(Node head)
    {
        Node temp = head;
        while(temp!=null)
        {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    public static void main(String[] args)
    {
        int [] arr = {8,999,67};
        Node head = convertArrayToDLL(arr);
        printDLL(head);
    }
}
