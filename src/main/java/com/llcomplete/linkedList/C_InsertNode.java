package main.java.com.llcomplete.linkedList;

public class C_InsertNode extends A_LinkedList{

    public static ListNode insertNode(ListNode head, int index, int insertionValue) {
        if (head == null) {
            if (index == 0) {
                return new ListNode(insertionValue);
            } else {
                System.out.println("Head is null, value can only be inserted at 0 index.");
                return  null;
            }
        }
        else if(index == 0)
        {
            return new ListNode(insertionValue,head);
        }

        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            if (count == index - 1) {
                ListNode newListNode = new ListNode(insertionValue,temp.next);
                temp.next = newListNode;
            }
            temp = temp.next;

        }
        return head;
    }

    /**
     * Instead of providing index, we provide value before which element has to be inserted. In both cases
     * we need to stop before the target index.
     */
    public static ListNode insertElementBeforeValue(ListNode head, int nextValue, int insertionValue) {
        if (head == null) {
                return  null;
        }
        else if(head.data == nextValue)
        {
            return new ListNode(insertionValue,head);
        }

        ListNode temp = head;
        while (temp.next != null) {
            if (nextValue == temp.next.data) {
                ListNode newListNode = new ListNode(insertionValue,temp.next);
                temp.next = newListNode;
                break;
            }
            temp = temp.next;

        }
        return head;
    }


    public static void main(String[] args)
    {
        int[] arr = new int[4];
        arr[0] = 0;
        arr[1] = 9;
        arr[2] = 7;
        arr[3] = 77;
        ListNode ll = convertArrToLL(arr);
        ll = insertNode(ll,5,50);
        printLL(ll);
        System.out.println("/**************************Insert value before x value******************/");
        int[] arr1 = new int[4];
        arr1[0] = 7;
        arr1[1] = 5;
        arr1[2] = 79;
        arr1[3] = 56;
        ll = convertArrToLL(arr1);
        ll = insertElementBeforeValue(ll,79,50);
        printLL(ll);
    }
}
