package main.java.com.llcomplete.linkedList;

public class K_DeleteNodeWithoutHead extends A_LinkedList {


    public static void main(String[] args) {
//        int[] arr = {1, 2};
//        ListNode ll = convertArrToLL(arr);
//        printLL(ll);
    }

    public static void deleteNode(ListNode node) {
        while(true)
        {
            node.val = node.next.val;
            if(node.next.next==null) //last second node
            {
                node.next = null;
                break;
            }
            node = node.next;
        }
    }

}
