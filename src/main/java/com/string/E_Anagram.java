package main.java.com.string;

import java.util.Arrays;

public class E_Anagram {

    public boolean isAnagram(String s, String t) {

        if(s.length()==t.length())
        {
            for(String val:s.split(""))
            {
                if(t.contains(val))
                    t= t.replaceFirst(val,"_");
                else
                    return false;
            }
            return true;
        }
        else
            return false;

    }

    public static boolean isAnagram2(String s, String t) {
        char[] sArr =  s.toCharArray();
        Arrays.sort(sArr);
        System.out.println(sArr);
        char[] tArr =  t.toCharArray();
        Arrays.sort(tArr);
        System.out.println(tArr);
        return Arrays.equals(sArr, tArr);
    }

    public static void main(String[] args)
    {
        System.out.println(isAnagram2("anagram",  "nagaram"));
    }
}
