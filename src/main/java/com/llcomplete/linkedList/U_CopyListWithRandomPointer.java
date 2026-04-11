package main.java.com.llcomplete.linkedList;

import java.util.HashMap;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class U_CopyListWithRandomPointer {

    /**
     * <a href="https://leetcode.com/problems/copy-list-with-random-pointer/description/">138. Copy List with Random Pointer</a>
     */
    public static Node copyRandomList(Node head) {
        //Address : value + 0-based index
        HashMap<String, Node> addressToPointer = new HashMap<>(); //OG's address to pointer mapping
        HashMap<Node,String> pointerToAddress = new HashMap<>(); //New's pointer to address mapping
        Node head1 = new Node(head.val);
        addressToPointer.put(head.val + String.valueOf(0), head1);
        pointerToAddress.put(head,head.val + String.valueOf(0));
        Node temp1 = head1;
        Node temp = head.next;
        int index = 1;
        while (temp != null) {
            int val = temp.val;
            temp1.next = new Node(val);
            temp1 = temp1.next;
            addressToPointer.put(val+String.valueOf( index), temp1);
            pointerToAddress.put(temp,val + String.valueOf(index));
            temp = temp.next;

            index++;
        }
        HashMap<Node,String> randomToAddress = new HashMap<>();
        temp = head;
        while(temp!=null)
        {
           randomToAddress.put(temp,pointerToAddress.get(temp.random)); //Node to address mapping (where random is pointing)
           temp = temp.next;
        }
        temp1 = head1;
        temp = head;
        while (temp != null) {
            if (temp.random != null) {
                temp1.random = addressToPointer.get(randomToAddress.get(temp)); //get the node at the same index where the original list's random was pointing
            } else {
                temp1.random = null;
            }
            temp = temp.next;
            temp1 = temp1.next;

        }

        return head1;

    }

    public static void main(String[] args)
    {
        Node head = new Node(1);
        Node node2 = new Node(2);
        node2.next = null;
        head.next = node2;
        head.random = node2;
        node2.random = node2;
        copyRandomList(head);
    }
}
