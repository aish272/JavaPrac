package main.java.com.llcomplete.linkedList;

import static main.java.com.llcomplete.linkedList.A_LinkedList.convertArrToLL;

public class X_SplitLLInParts {

    /**
     * <a href="https://leetcode.com/problems/split-linked-list-in-parts/description/">725. Split Linked List in Parts</a>
     */
    public static ListNode[] splitListToParts(ListNode head, int k) {

        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        ListNode[] ans = new ListNode[k];
        int index = 0;
        int numOfEle = size / k;
        int remaining = size % k;
        temp = head;
        if (numOfEle == 0) {
            while (temp != null) {
                ListNode ln = new ListNode(temp.val);
                ans[index] = ln;
                temp = temp.next;
                index++;
            }

        } else {
            while (temp != null) {
                int toBeAssigned;
                if (remaining != 0) {
                    toBeAssigned = numOfEle + 1;
                    remaining--;
                } else {
                    toBeAssigned = numOfEle;
                }
                ListNode ln = new ListNode(temp.val);
                ListNode temp1 = ln;
                ans[index] = ln;
                toBeAssigned--;
                while (toBeAssigned > 0) {
                    temp = temp.next;
                    temp1.next = new ListNode(temp.val);
                    temp1 = temp1.next;
                    toBeAssigned--;
                }
                index++;
                temp = temp.next;
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ListNode ll = convertArrToLL(arr);
        splitListToParts(ll, 3);

    }
}
