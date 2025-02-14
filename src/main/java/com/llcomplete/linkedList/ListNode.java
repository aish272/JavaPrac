package main.java.com.llcomplete.linkedList;

public class ListNode {


        public int data;
        public ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }

        ListNode() {
            this.data = 0;
            this.next = null;
        }
        ListNode(int data, ListNode listNode) {
            this.data = data;
            this.next = listNode;
        }

}
