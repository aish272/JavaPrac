package main.java.com.arrays1;

public class M_LongestSubstringWithoutRepeatingChars {


    public static int lengthOfLongestSubstring(String s) {
        int longestNonRepeatedCharSubStringLen = 0;

        if(s.length()==0)
            return 0;
        else {
            for (int outerCounter = 0; outerCounter < s.length(); outerCounter++) {
                int[] hashArray = new int[256];
                for (int innerCounter = outerCounter; innerCounter < s.length(); innerCounter++) {
                    if (hashArray[s.charAt(innerCounter)] == 1) {
                        longestNonRepeatedCharSubStringLen = Math.max(longestNonRepeatedCharSubStringLen, (innerCounter - outerCounter));
                        break;
                    }
                    else if (s.length()==innerCounter+1){
                        longestNonRepeatedCharSubStringLen = Math.max(longestNonRepeatedCharSubStringLen, (innerCounter - outerCounter)+1);
                        break;
                    }

                    hashArray[s.charAt(innerCounter)] = 1;
                }
            }
            return longestNonRepeatedCharSubStringLen;
        }

    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        String s = " ";
        int a = s.charAt(0);
        System.out.println(a);
    }
}
