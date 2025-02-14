package main.java.com.arrays1;

public class M_LongestSubstringWithoutRepeatingChars_SlidingWindow {


    public static int lengthOfLongestSubstringSlidingWindow(String s) {
        int longestNonRepeatedCharSubStringLen = 0;

        if(s.length()==0)
            return 0;
        else {
            int l = 0;
            int r = 0;
            int[] hashArray = new int[255];
            for(int counter =0;counter<255;counter++) {
                hashArray[counter] = -1;
            }
            while(r<s.length())
            {
                if(hashArray[s.charAt(r)]!=-1)
                {
                    if(hashArray[s.charAt(r)]>=l)
                    {
                        l= hashArray[s.charAt(r)] +1;
                    }
                    longestNonRepeatedCharSubStringLen = Math.max(longestNonRepeatedCharSubStringLen,r-l+1);
                }
                hashArray[s.charAt(r)] =r;
                r++;
            }
            return longestNonRepeatedCharSubStringLen;
        }

    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringSlidingWindow("abcabcbb"));
        String s = " ";
        int a = s.charAt(0);
        System.out.println(a);
    }
}
