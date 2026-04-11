package main.java.com.llcomplete.doublyLinkedList;

/**
 * <a href="https://leetcode.com/problems/design-browser-history/">1472. Design Browser History</a>
 */
class DLLListNode {
    DLLListNode next;
    DLLListNode prev;
    String val;

    public DLLListNode(String val) {
        this.val = val;
    }
}
class BrowserHistory {

    DLLListNode history;
    DLLListNode current;
    DLLListNode previous;
    boolean forwardBack = false;

    public BrowserHistory(String homepage) {

        history = new DLLListNode(homepage);
        current = history;

    }

    public void visit(String url) {

        DLLListNode temp = new DLLListNode(url);
        temp.prev = current;
        current.next = temp;
        current = current.next;

    }

    public String back(int steps) {

        forwardBack = true;
        while (steps > 0 && current.prev != null) {
            current = current.prev;
            steps--;
        }
        return current.val;
    }

    public String forward(int steps) {
        forwardBack = true;
        while (steps > 0 && current.next != null) {
            current = current.next;
            steps--;
        }
        return current.val;

    }
}
public class D_DesignBrowserHistory {
}
