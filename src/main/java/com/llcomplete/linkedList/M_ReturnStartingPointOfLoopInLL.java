package main.java.com.llcomplete.linkedList;

import java.util.ArrayList;
import java.util.List;

public class M_ReturnStartingPointOfLoopInLL extends A_LinkedList {

    public ListNode detectCycle(ListNode head) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode temp = head;
        nodes.add(temp);
        while(temp!=null)
        {
            temp = temp.next;
            if(nodes.contains(temp))
            {
                return temp;
            }
            nodes.add(temp);
        }
        return null;

    }

    public ListNode detectCycleUsingSlowFastPointer(ListNode head) {
        if (head == null || head.next==null)
            return null;
        ListNode fast = head;
        ListNode slow = head;
        while ( fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

}
