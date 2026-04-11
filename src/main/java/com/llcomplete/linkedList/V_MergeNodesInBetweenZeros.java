package main.java.com.llcomplete.linkedList;

public class V_MergeNodesInBetweenZeros {

    /**
     * <a href="https://leetcode.com/problems/merge-nodes-in-between-zeros/">2181. Merge Nodes in Between Zeros</a>
     */
    public ListNode mergeNodes(ListNode head) {
        int zeroCount = 0;
        ListNode temp = head;
        ListNode head1 = new ListNode();
        ListNode temp1 = head1;
        int sum = 0;
        while (temp != null) {

            sum += temp.val;
            if (temp.val == 0) {
                zeroCount++;
            }
            if (zeroCount == 2) {
                temp1.val = sum;
                sum = 0;
                zeroCount = 1;
                if (temp.next != null) {
                    ListNode current = new ListNode();
                    temp1.next = current;
                    temp1 = temp1.next;
                }
            }
            temp = temp.next;

        }
        return head1;

    }
}
