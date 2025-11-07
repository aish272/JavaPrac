package main.java.com.string;

public class K_RemoveOuterParentheses {

    public static String removeOuterParentheses(String s) {

        int i = 0;
        int j = 0;
        String ans = "";
        int openCount = 0;
        int closeCount = 0;
        while (j < s.length()) {
            if (s.charAt(j) == '(') {
                openCount++;
                j++;
            } else {
                closeCount++;
                j++;
            }
            if (openCount == closeCount) {
                ans = ans.concat(s.substring(i + 1, j - 1));
                i = j;

            }

        }
        return ans;


    }

    public static void main(String[] args)
    {
        System.out.println( removeOuterParentheses("(()())(())"));
    }

}
