package main.java.com.recursion;

import java.util.ArrayList;
import java.util.List;

public class F_GenerateParentheses {


    /**
     <a href="https://leetcode.com/problems/generate-parentheses/">22. Generate Parentheses</a>
     */
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generateParenthesisCombo(n,0,0, new StringBuilder(),ans);
        return ans;
    }
    public static void generateParenthesisCombo(int n, int openParenthesis, int closedParenthesis, StringBuilder combo, List<String> ans)
    {
        if(openParenthesis==n&&closedParenthesis==n)
        {
            ans.add(String.valueOf(combo));
            return;
        }
        if(openParenthesis<n)
        {
            combo.append("(");
            generateParenthesisCombo(n,openParenthesis+1,closedParenthesis,combo,ans);
            combo.deleteCharAt(combo.length()-1);
        }
        if(closedParenthesis<openParenthesis)
        {
            combo.append(")");
            generateParenthesisCombo(n,openParenthesis,closedParenthesis+1,combo,ans);
            combo.deleteCharAt(combo.length()-1);
        }
    }
    public static void main(String[] args)
    {
        generateParenthesis(2);
    }
}
