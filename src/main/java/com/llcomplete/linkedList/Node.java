package main.java.com.llcomplete.linkedList;

public class Node {


        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        Node() {
            this.data = 0;
            this.next = null;
        }
        Node(int data, Node node) {
            this.data = data;
            this.next = node;
        }

}
