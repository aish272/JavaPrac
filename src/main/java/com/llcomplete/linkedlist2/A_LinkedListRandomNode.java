package main.java.com.llcomplete.linkedlist2;

import main.java.com.llcomplete.linkedList.ListNode;

import java.util.concurrent.ThreadLocalRandom;

/**
 * <a href="https://leetcode.com/problems/linked-list-random-node/description/">382. Linked List Random Node</a>
 * <a href="https://www.geeksforgeeks.org/java/generating-random-numbers-in-java/">GFG Article</a>
 */
public class A_LinkedListRandomNode {

    ListNode head;
    int[] arr;
    int size = 0;

    public A_LinkedListRandomNode(ListNode head) {
        this.head = head;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        arr = new int[size];
        temp = head;
        for (int i = 0; i < size; i++) {
            arr[i] = temp.val;
            temp = temp.next;

        }

    }

    public int getRandom() {
// By using Math class. Leetcode performance was not efficient.
//        int random = (int) (Math.random() % size);
//        return arr[random];

        int random = ThreadLocalRandom.current().nextInt(1, size + 1) % size;
        return arr[random];

    }
}
