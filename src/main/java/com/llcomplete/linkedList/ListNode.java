package main.java.com.llcomplete.linkedList;

public class ListNode {


        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }

        ListNode() {
            this.val = 0;
            this.next = null;
        }
        ListNode(int val, ListNode listNode) {
            this.val = val;
            this.next = listNode;
        }

}
