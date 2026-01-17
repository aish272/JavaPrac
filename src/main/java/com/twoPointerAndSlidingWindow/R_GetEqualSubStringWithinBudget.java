package main.java.com.twoPointerAndSlidingWindow;

public class R_GetEqualSubStringWithinBudget
{
    /**
     * <a href="https://leetcode.com/problems/get-equal-substrings-within-budget/description/">1208. Get Equal Substrings Within Budget</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=MF2MgJQuFhA&list=PLpIkg8OmuX-J2Ivo9YdY7bRDstPPTVGvN&index=21">Video solution link</a>
     */
    public static int equalSubstring(String s, String t, int maxCost) {
        int i = 0;
        int j = 0;
        int len = 0;
        while (j < t.length()) {
            int cost = Math.abs(s.charAt(j) - t.charAt(j));
            if (maxCost - cost >= 0) {
                maxCost -= cost;

            } else {
                while (i <= j && maxCost - cost < 0) {
                    maxCost += Math.abs(s.charAt(i) - t.charAt(i));
                    i++;
                }
                if (maxCost - cost >= 0) {
                    maxCost -= cost;

                }
            }
            len = Math.max(j - i + 1, len);
            j++;
        }
        return len;

    }
    public static int equalSubstringSecondWay(String s, String t, int maxCost) {
        int i = 0;
        int j = 0;
        int len = 0;
        while (j < t.length()) {
            int cost = Math.abs(s.charAt(j) - t.charAt(j));
            while (i <= j && maxCost - cost < 0) {
                maxCost += Math.abs(s.charAt(i) - t.charAt(i));
                i++;
            }
            if (maxCost - cost >= 0) {
                maxCost -= cost;
            }
            len = Math.max(j - i + 1, len);
            j++;
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(equalSubstring("abcd","cdef",3));

    }


}
