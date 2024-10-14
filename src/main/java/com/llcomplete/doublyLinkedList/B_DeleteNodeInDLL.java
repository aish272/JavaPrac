package main.java.com.llcomplete.doublyLinkedList;

public class B_DeleteNodeInDLL extends A_DoublyLinkedList{

    public static Node  deleteANodeInDLL(Node head, int index)
    {
        if(head == null || (index ==0 && head.next==null))
        {
            return null;
        }
        else if(index == 0)
        {
            head.next.prev = null;
            return head.next;
        }

        Node temp = head.next;
        int count =1;
        while (temp.next!=null)
        {
            if(count==index-1)
            {


                temp.next = temp.next.next;
                if(temp.next!=null)
                {
                    temp.next.prev = temp;
                }
                break;
            }
            temp = temp.next;
            count++;
        }
        return head;
    }

    public static void main(String[] args)
    {
        int[] arr = {9,889,6,5,8,0,8};
        Node dll = convertArrayToDLL(arr);
        dll = deleteANodeInDLL(dll,3);
        printDLL(dll);

    }
}
