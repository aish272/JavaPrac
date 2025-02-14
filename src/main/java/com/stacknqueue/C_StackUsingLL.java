package main.java.com.stacknqueue;

import main.java.com.llcomplete.linkedList.ListNode;

class Stack{
     ListNode top;
    int size;

    Stack()
    {
        this.top = null;
        this.size = 0;
    }

    public  void push(int x)
    {
        ListNode temp = new ListNode(x);
        temp.next = top;
        top = temp;
        size++;

    }

    public int pop()
    {
        if(top!=null) {
            int ele = top.data;
            top = top.next;
            size--;
            return ele;
        }
        return -1;
    }

    public int peek()
    {
        if(top!=null) {
            return top.data;
        }
        return -1;
    }

}

public class C_StackUsingLL {

    public static void main (String[] args) {

        Stack s = new Stack();
        s.push(7);
        System.out.println(s.peek());
        s.push(90);
        System.out.println(s.peek());
        s.pop();
        System.out.println(s.peek());

    }


}
