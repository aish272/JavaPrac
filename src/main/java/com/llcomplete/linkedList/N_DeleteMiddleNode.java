package main.java.com.llcomplete.linkedList;

public class N_DeleteMiddleNode {

    /**
     * <a href="https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/">2095. Delete the Middle Node of a Linked List</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=ePpV-_pfOeI">Video solution link</a>
     */
    public ListNode deleteMiddle(ListNode head) {

        if(head==null||head.next==null)
            return null;
        ListNode slow= head;
        ListNode fast = head;
        fast = fast.next.next;
        while(fast!=null && fast.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public ListNode deleteMiddleBrute(ListNode head) {

        if(head==null||head.next==null)
            return null;
        ListNode temp= head;
        int numOfNode =0;
        while(temp!=null)
        {
            numOfNode++;
            temp = temp.next;
        }
        int mid = numOfNode/2; //This node is one before the one which we want to delete
        temp = head;
        while (mid!=0)
        {
            mid--;
            if(mid==0)
            {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }

        return head;
    }


}
