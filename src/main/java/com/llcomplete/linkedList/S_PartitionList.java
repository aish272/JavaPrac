package main.java.com.llcomplete.linkedList;

import java.util.ArrayList;
import java.util.List;

import static main.java.com.llcomplete.linkedList.A_LinkedList.convertArrToLL;

/**
 * <a href="https://leetcode.com/problems/partition-list/description/">86. Partition List</a>
 */
public class S_PartitionList {

    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        List<ListNode> before = new ArrayList<>();
        List<ListNode> after = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            if (temp.val < x) {
                before.add(temp);
            } else {
                after.add(temp);
            }
            temp = temp.next;
        }
        if (!before.isEmpty()) {
            head = before.get(0);
            temp = head;
            for (int i = 1; i < before.size(); i++) {
                temp.next = before.get(i);
                temp = temp.next;
            }
            temp = before.get(before.size() - 1);
        } else {
            return head;
        }

        for (ListNode node : after) {
            temp.next = node;
            temp = temp.next;
        }
        temp.next = null;
        return head;

    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 2, 5, 2};
        ListNode ll = convertArrToLL(arr);
        partition(ll, 3);

    }
}
