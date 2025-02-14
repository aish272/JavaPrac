package main.java.com.string;

import java.util.HashMap;

public class B_RomanToInteger {

    public static int romanToInt(String s) {
        int ans = 0;
        HashMap<String,Integer> dictionary = new HashMap<>();


        dictionary.put("I",1);
        dictionary.put("V",5);
        dictionary.put("X",10);
        dictionary.put("L",50);
        dictionary.put("C",100);
        dictionary.put("D",500);
        dictionary.put("M",1000);


        if(dictionary.containsKey(s))
            return dictionary.get(s);
        else
        {
            for (int index=0;index<s.length();index++)
            {
                int val = dictionary.get(s.split("")[index]);
                int nextVal =0;
                if(index<s.length()-1) {
                    nextVal = dictionary.get(s.split("")[index+1]);
                }
                if(val*10==nextVal || val*5 == nextVal)
                {
                    val = nextVal-val;
                    index++;
                }
                ans += val;
            }
        }
        return ans;
    }

    public static void  main(String[] args)
    {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
