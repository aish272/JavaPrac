package main.java.com.llcomplete.linkedList;

import java.util.Stack;

public class W_Add2Nums2 {

    /**
     * <a href="http://leetcode.com/problems/add-two-numbers-ii/description/">445. Add Two Numbers II</a>
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode temp1 = l1;
        ListNode temp2 = l2;
        StringBuilder s1 = new StringBuilder();
        while (temp1 != null) {
            s1.append(temp1.val);
            temp1 = temp1.next;
        }
        StringBuilder s2 = new StringBuilder();
        while (temp2 != null) {
            s2.append(temp2.val);
            temp2 = temp2.next;
        }
        int num = Integer.parseInt(s1.toString()) + Integer.parseInt(s2.toString());
        StringBuilder s3 = new StringBuilder();
        s3.append(num);

        ListNode ans = new ListNode(Integer.parseInt(String.valueOf(s3.charAt(0))));
        ListNode temp = ans;
        int index = 1;
        while (index < s3.length()) {
            temp.next = new ListNode(Integer.parseInt(String.valueOf(s3.charAt(index))));
            temp = temp.next;
            index++;

        }

        return ans;

    }

    public ListNode addTwoNumbersBetter(ListNode l1, ListNode l2) {

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        int carry = 0;
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        ListNode head = null;

        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            int sum = 0;
            if (!s1.isEmpty()) {
                sum += s1.pop();
            }
            if (!s2.isEmpty()) {
                sum += s2.pop();
            }
            sum += carry;
            ListNode n = new ListNode(sum % 10);
            n.next = head;
            head = n;
            carry = sum / 10;
        }

        return head;

    }
}
