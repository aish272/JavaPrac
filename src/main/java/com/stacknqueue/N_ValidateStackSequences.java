package main.java.com.stacknqueue;
import java.util.Stack;

public class N_ValidateStackSequences {

    /**
     * <a href="https://leetcode.com/problems/validate-stack-sequences/">946. Validate Stack Sequences</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=HEh7EtNSXtg&t=532s">Video solution link</a>
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0;
        int j = 0;
        int len = pushed.length;
        Stack<Integer> s = new Stack<>();
        while (i < len && j < len) {
            s.push(pushed[i]);
            while (!s.isEmpty()&&j < len && s.peek() == popped[j]) {
                s.pop();
                j++;
            }
            i++;
        }
        return s.isEmpty() ? true : false;
    }
}
