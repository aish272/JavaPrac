package main.java.com.llcomplete.linkedList;

public class B_DeleteNode extends A_LinkedList {

    public static ListNode deleteNode(ListNode head, int nodeNum) {
        if (head == null)
            return head;
        else if (nodeNum == 0) {
            return head.next;
        } else {
            int count = 1;
            ListNode temp = head;
            while (temp.next != null)
            {
                //ListNode prev = temp;
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
       ListNode head = convertArrToLL(arr);
       head = deleteNode(head,5);
       printLL(head);
    }
}
