package main.java.com.twoPointerAndSlidingWindow;

public class L_MaxNumOfVowelsInSubstringOfGivenLen {

    /**
     * <a href="https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/">1456. Maximum Number of Vowels in a Substring of Given Length</a>
     */
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public int maxVowels(String s, int k) {

        int l = 0;
        int r = 0;
        int vowelCount = 0;
        int maxLen = 0;
        while (r < s.length()) {
            if (isVowel(s.charAt(r))) {
                vowelCount++;
            }
            if (r - l + 1 == k) {
                maxLen = Math.max(maxLen, vowelCount);
                if (maxLen == k) {
                    return maxLen; //if all the chars are vowel in the window which means len equal to k then no need to continue as we cannot have maxLen more than this.
                }
                if (isVowel(s.charAt(l))) //when window len is equal to k and left is a vowel reduce the count of vowel and shift the window forward
                {
                    vowelCount--;

                }
                l++;
            }
            r++;
        }
        return maxLen;

    }
}
