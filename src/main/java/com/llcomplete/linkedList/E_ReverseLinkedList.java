package main.java.com.llcomplete.linkedList;

public class E_ReverseLinkedList extends A_LinkedList{
    public static Node reverseLinkedList(Node head)
    {
        String llData = "";
        Node temp = head;
        if(head!=null) {
            while (temp != null) {
                llData = llData.concat(String.valueOf(temp.data));
                llData = llData.concat(",");
                temp = temp.next;
            }
        }
        else
        {
            return null;
        }
        temp = head;
        System.out.println(llData);
        String [] arr = llData.split(",");
        for (int i =arr.length-1; i>=0; i--) {

            temp.data = Integer.parseInt( arr[i]);

            temp = temp.next;
        }
        return head;

    }
    public static void main(String[] args)
    {
        int[] arr = {9,8,-7,6};
        Node ll = convertArrToLL(arr);
        printLL(ll);
        ll = reverseLinkedList(ll);
        printLL(ll);
    }
}
