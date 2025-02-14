package main.java.com.llcomplete.linkedList;

public class F_DetectALoop extends A_LinkedList {

    public static Boolean detectLoop(ListNode head)
    {
        ListNode fast = head;
        ListNode slow = head;
        if(head!=null) {
            while (fast.next != null && fast.next.next!=null) {
                fast = fast.next.next;
                slow = slow.next;
                if(fast==slow)
                {
                    return true;
                }
            }
        }
        return false;
    }

}
