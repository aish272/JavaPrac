package main.java.com.twoPointerAndSlidingWindow;

public class U_MinLenOfStrAfterDeletingSimilarEnds {

    /**
     * <a href="https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/">1750. Minimum Length of String After Deleting Similar Ends</a>
     */
    public int minimumLength(String s) {

        if (s.length() == 1) return 1;

        int start = 0;
        int end = s.length() - 1;
        while (end > start) {

            if (s.charAt(start) == s.charAt(end)) {
                char identical = s.charAt(start);
                while (end > start && (s.charAt(start) == identical || s.charAt(end) == identical)) {
                    while (end > start && s.charAt(start) == identical) start++;
                    while (end > start && s.charAt(end) == identical) end--;
                }
                if (end == start && s.charAt(start) != identical) return 1;

            } else {
                break;
            }
        }
        return end != start ? end - start + 1 : 0;

    }
}
