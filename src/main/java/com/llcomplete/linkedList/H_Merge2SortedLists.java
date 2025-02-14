package main.java.com.llcomplete.linkedList;

public class H_Merge2SortedLists extends A_LinkedList {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode head;
        ListNode temp;
        if(list1==null&&list2==null)
            return null;
        if (list1==null||list2==null)
            return list1==null?list2:list1;

        if(list1.data<list2.data) {
            head = new ListNode(list1.data);
            list1 = list1.next;
        }
        else
        {
            head = new ListNode(list2.data);
            list2 = list2.next;
        }
        ListNode current = head;
        while(list1!=null&&list2!=null)
        {
            if(list1.data<list2.data) {
                temp = new ListNode(list1.data);
                list1 = list1.next;
            }
            else
            {
                temp = new ListNode(list2.data);
                list2 = list2.next;
            }
            current.next = temp;
            current = temp;
        }
        while (list1!=null)
        {
            temp = new ListNode(list1.data);
            current.next = temp;
            current = temp;
            list1 = list1.next;
        }
        while (list2!=null)
        {
            temp = new ListNode(list2.data);
            current.next = temp;
            current = temp;
            list2 = list2.next;
        }
        return head;

        /**
         ListNode head;
         ListNode temp;
         if(list1.val<list2.val) {
         head = new ListNode(list1.val);
         list1 = list1.next;
         }
         else
         {
         head = new ListNode(list2.val);
         list2 = list2.next;
         }
         ListNode current = head;
         while(list1!=null&&list2!=null)
         {
         if(list1.val<list2.val) {
         temp = new ListNode(list1.val);
         list1 = list1.next;
         }
         else
         {
         temp = new ListNode(list2.val);
         list2 = list2.next;
         }
         current.next = temp;
         current = temp;
         }
         while (list1!=null)
         {
         temp = new ListNode(list1.val);
         current.next = temp;
         current = temp;
         list1 = list1.next;
         }
         while (list2!=null)
         {
         temp = new ListNode(list2.val);
         current.next = temp;
         current = temp;
         list2 = list2.next;
         }
         return head;
         */

    }

    public static void main(String[] args) {
        int[] arr = {1,2,4};
        int[] arr2 = {1,3,4};
        ListNode ll = convertArrToLL(arr);
        ListNode ll2 = convertArrToLL(arr2);
        printLL(mergeTwoLists(ll,ll2));

    }

}
