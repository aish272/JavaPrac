package main.java.com.string;

public class Z_CheckIfSentenceIsPangram {

    /**
     * <a href="https://leetcode.com/problems/check-if-the-sentence-is-pangram/description/">1832. Check if the Sentence Is Pangram</a>
     */
    public boolean checkIfPangram(String sentence) {

        int[] hash = new int[26];
        for (char c : sentence.toCharArray()) {
            hash[c - 'a'] = 1;
        }
        for (int i : hash) {
            if (i != 1) {
                return false;
            }
        }

        return true;

    }
}
