package main.java.com.string;

import java.util.HashMap;
import java.util.Map;

public class S_CountChars {

    public static Map<String,Integer>  countChars(String s)
    {
        Map<String,Integer> freq = new HashMap<>();
        for (int i=0;i<s.length();i++)
        {

            freq.put(String.valueOf(s.charAt(i)), freq.getOrDefault(String.valueOf(s.charAt(i)),0)+1);
        }
        return freq;

    }
    public static void main(String[] args)
    {
        System.out.println( countChars("eattter"));
    }
}
