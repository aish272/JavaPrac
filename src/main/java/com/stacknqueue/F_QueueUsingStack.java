package main.java.com.stacknqueue;


import java.util.Stack;

class MyQueue {

    Stack<Integer> s;
    Stack<Integer> tempStack;

    public MyQueue() {
        s = new Stack<>();
        tempStack = new Stack<>();
    }

    public void push(int x) {
        while (!s.empty())
        {
            tempStack.push(s.pop());
        }
        s.push(x);
        while (!tempStack.empty())
        {
            s.push(tempStack.pop());
        }
    }

    public int pop() {
        return s.pop();
    }

    public int peek() {
        return s.peek();
    }

    public boolean empty() {
        return s.isEmpty();
    }
}

public class F_QueueUsingStack {
}
