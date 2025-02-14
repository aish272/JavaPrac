package main.java.com.llcomplete.linkedList;

public class G_YIntersectionPoint {

    public static ListNode findIntersectingNode(ListNode headA, ListNode headB)
    {
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        if(headA ==null || headB ==null)
        {
            return null;
        }
        while(temp1!=temp2)
        {
            temp1 = temp1.next;
            temp2 = temp2.next;

            if(temp1==temp2)
            {
                return temp1;
            }
            if(temp1==null)
            {
                temp1 = headB;
            } else if (temp2==null) {
                temp2 = headA;
            }

        }
        return temp1;
    }
}
