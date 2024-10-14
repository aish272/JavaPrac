package main.java.com.stacknqueue;

import java.util.Stack;

public class H_MinEleInStack {

    class MinStack {

        Stack<Long> s;
        Long min;
        public MinStack() {
            s= new Stack<>();
            min = Long.MAX_VALUE;
        }

        public void push(int val) {

            Long value = Long.valueOf(val);

            if(s.isEmpty())
            {
                s.push(value);
                min = value;
            }
            else
            {
                if(value>min)
                {
                    s.push(value);
                }
                else {
                    s.push(2*value-min);
                    min = value;
                }
            }

        }

        public void pop() {
            if(s.isEmpty())
            {
                //do nothing
            }
            else
            {
                Long ele = Long.valueOf(s.pop());
                if(ele<min)
                {
                   min = 2 * min -ele;
                }
            }
        }

        public int top() {
            if(s.peek()>min)
            {
                return s.peek().intValue();
            }
            return min.intValue();
        }

        public int getMin() {
            return min.intValue();
        }
    }
}
