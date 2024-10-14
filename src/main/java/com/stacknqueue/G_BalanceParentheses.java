package main.java.com.stacknqueue;

import java.util.Stack;

public class G_BalanceParentheses {

    public static boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        String[] parenthesesArr = s.split("");
        for (int i=0;i<s.length();i++)
        {
            if(parenthesesArr[i].equals("{") || parenthesesArr[i].equals("(") || parenthesesArr[i].equals("[") )
            {
                stack.push(parenthesesArr[i]);
            }
            else if (stack.isEmpty()) {
                return false;
            }
            else {
                switch (parenthesesArr[i])
                {
                    case "}"->
                    {
                       if(!(stack.peek().equals("{")))
                       {
                           return false;
                       }
                       else
                       {
                           stack.pop();
                       }
                    }
                    case "]"->
                    {
                        if(!(stack.peek().equals("[")))
                        {
                            return false;
                        }
                        else
                        {
                            stack.pop();
                        }
                    }
                    case ")"->
                    {
                        if(!(stack.peek().equals("(")))
                        {
                            return false;
                        }
                        else
                        {
                            stack.pop();
                        }
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args)
    {
        System.out.println(isValid("{{{"));
    }
}


