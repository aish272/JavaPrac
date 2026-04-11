package main.java.com.greedyAlgo;

public class P_MaxOpsToMove1sToTheEnd {


    /**
     * <a href="https://leetcode.com/problems/maximum-number-of-operations-to-move-ones-to-the-end/">3228. Maximum Number of Operations to Move Ones to the End</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=Hr45fl6esng&list=PLpIkg8OmuX-J8_n8Vy9P9I3KvyDcPMzRU&index=51">Video solution link</a>
     */
    public int maxOperations(String s) {

        int countOf1 = 0;
        int operations = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                countOf1++;
            } else {
                operations += countOf1;
                while (i < s.length() && s.charAt(i) == '0') {
                    i++;

                }
                countOf1++;
            }
        }
        return operations;

    }
}
