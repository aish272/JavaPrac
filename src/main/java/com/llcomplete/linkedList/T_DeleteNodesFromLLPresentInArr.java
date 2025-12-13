package main.java.com.llcomplete.linkedList;

import static main.java.com.llcomplete.linkedList.A_LinkedList.convertArrToLL;

public class T_DeleteNodesFromLLPresentInArr {

    public static ListNode modifiedList(int[] nums, ListNode head) {

        int max = Integer.MIN_VALUE;
        for (int i : nums) {
            if (max < i) {
                max = i;
            }
        }
        int[] hash = new int[max + 1];
        for (int i : nums) {
            hash[i] = 1;
        }
        ListNode temp = head;
        ListNode prev = null;
        while (temp != null) {
            if (temp.val <= max && hash[temp.val] == 1) {
                if (prev != null) {
                    prev.next = temp.next;

                    temp = temp.next;

                }
                else {
                    head = temp.next;
                    temp = head;
                }
            } else {
                prev = temp;
                temp = temp.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1,2,1,2};
        ListNode ll = convertArrToLL(arr);
        modifiedList(new int[]{1},ll );

    }
}
