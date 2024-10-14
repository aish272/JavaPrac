package main.java.com.stacknqueue;

public class A_StackUsingArray {

    static int[] stackArray = new int[10];
    static int top = -1;

    public static void push(int x) {
        if (top != -1 || top != stackArray.length - 1) {
            top += 1;
            stackArray[top] = x;

        }
    }

    public static int pop() {
        if (top != -1) {
            top -= 1;
            return stackArray[top];
        }
        else
            return -1;
    }

    public static int top()
    {
        if (top != -1) {
            return stackArray[top];
        }
        else
            return -1;
    }

    public static void main(String[] args)
    {
        push(9);
        push(89);
        System.out.println(top());
        pop();
        System.out.println(top());
        push(67);
        System.out.println(top());


    }
}
