package main.java.com.string;

public class O_RotateString {
    /**
     * <a href="https://leetcode.com/problems/rotate-string/description/">796. Rotate String</a>
     */
    public static boolean rotateString(String s, String goal) {
        if (s.equals(goal))
            return true;
        if (s.length() != goal.length())
            return false;
        for (int i = 0; i < s.length(); i++) {
            if (s.contains(goal.substring(0, i+1))) {
            } else {
                return s.indexOf(goal.substring(i)) == 0;
            }
        }
        return true;

    }

    public static void main(String[] args)
    {
        System.out.println(rotateString("defdefdefabcabc", "defdefabcabcdef"));

    }

}
