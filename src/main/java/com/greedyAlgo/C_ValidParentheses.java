package main.java.com.greedyAlgo;

public class C_ValidParentheses {

    /**
     * <a href="https://leetcode.com/problems/valid-parenthesis-string/">678. Valid Parenthesis String</a>
     * <br/>
     * <a href="https:https://www.youtube.com/watch?v=cHT6sG_hUZI">Video solution link</a>
     */
    //some cases did not pass in LC.
    public static boolean checkValidString(String s) {
        int openParenthesisCount =0;
        int asteriskCount =0;
        for(int i=0;i<s.length();i++)
        {
            switch (s.charAt(i))
            {
                case '('->
                    openParenthesisCount++;
                case ')'-> {
                    if (openParenthesisCount > 0)
                    {
                        openParenthesisCount--;
                    }
                }
                case '*'->
                        asteriskCount++;
            }
        }

        return openParenthesisCount<=asteriskCount;
    }

    public static boolean checkValidStringStriverSol(String s) {
         int min=0;
         int max=0;
        for(int i=0;i<s.length();i++)
        {
            switch (s.charAt(i))
            {
                case '('-> {
                    max++;
                    min++;
                }
                case ')'-> {
                    max--;
                    min--;
                }
                case '*'->
                {
                    min--;
                    max++;
                }
            }
            if(min<0)
                min=0;
            if(max<0)
                return false;
        }

        return min==0;

    }

    public static void main(String[] args) {
        System.out.println(checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));

    }


}
