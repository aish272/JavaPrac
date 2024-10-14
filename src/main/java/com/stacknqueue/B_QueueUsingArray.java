package main.java.com.stacknqueue;

public class B_QueueUsingArray {
    static int[] queueArray = new int[10];
    static int start = -1;
    static int end = -1;
    static int size = 0;

    public static void push(int x)
    {
        if(size<queueArray.length)
        {
            if(start==-1&&end==-1)
            {
                start +=1;

            }
            end = (end+1) % queueArray.length;
            queueArray[end] = x;
        }
    }

    public static int pop()
    {
        if(start==-1&&end==-1)
        {
            return -1;

        }
        if(size==1)
        {
            start = -1;
            end = -1;
        }
        int ele = queueArray[start];
        start = (start+1) % queueArray.length;
        size -= 1;
        return ele;
    }

    public static  int top()
    {
        if(size!=0)
        {
            return queueArray[start];
        }
        return -1;
    }

    public static void main(String[] args)
    {
        push(87);
        pop();
        System.out.println(top());
        push(67);
        System.out.println(top());
        push(89);
        push(54);
        System.out.println(top());
        pop();
        System.out.println(top());
    }

}
