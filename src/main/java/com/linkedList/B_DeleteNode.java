package main.java.com.linkedList;

public class B_DeleteNode extends A_LinkedList {

    public static Node deleteNode(Node head, int nodeNum) {
        if (head == null)
            return head;
        else if (nodeNum == 0) {
            return head.next;
        } else {
            int count = 1;
            Node temp = head;
            while (temp.next != null)
            {
                //Node prev = temp;
                if(count==nodeNum)
                {
                    temp.next = temp.next.next;
                    break;
                }
                count++;
                temp = temp.next ;
            }
            return head;

        }
    }

    public static void main(String[] args)
    {
       int[] arr = {3,8,9,7,8} ;
       Node head = convertArrToLL(arr);
       head = deleteNode(head,5);
       printLL(head);
    }
}
