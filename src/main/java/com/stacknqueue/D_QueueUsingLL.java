package main.java.com.stacknqueue;

import main.java.com.llcomplete.linkedList.ListNode;

class Queue
{
    ListNode start;
    ListNode end;
    int size;
    Queue()
    {
        this.start = null;
        this.end = null;
        this.size = 0;
    }

    public void push(int x)
    {
        ListNode temp = new ListNode(x);
        if(start == null)
        {
            start = temp;
            end = temp;
        }
        else
        {
            end.next = temp;
            end = temp;
        }
        size ++;
    }

    public int pop()
    {
        if(start==null)
        {
            return -1;
        }
        int ele = start.data;
        start = start.next;
        // last element was popped out, end has to point to null too.
        // So that garbage collector can delete last location
        if(start==null)
        {
            end = null;
        }
        size --;
        return ele;

    }
    public int peek()
    {
        if(start==null)
        {
            return -1;
        }

        return start.data;

    }
    public int getSize()
    {
        return size;
    }
}

public class D_QueueUsingLL {

    public static void main(String[] args)
    {
        Queue q = new Queue();
        System.out.println(q.pop());
        System.out.println(q.peek());
        q.push(6);
        System.out.println(q.peek());
        q.push(7);
        System.out.println(q.getSize());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.peek());

    }
}
