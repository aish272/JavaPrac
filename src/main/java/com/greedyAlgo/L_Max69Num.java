package main.java.com.greedyAlgo;

public class L_Max69Num {

    /**
     * <a href="https://leetcode.com/problems/maximum-69-number/">1323. Maximum 69 Number</a>
     */
    public int maximum69Number(int num) {

        char[] n = String.valueOf(num).toCharArray();
        int i = 0;
        for (; i < n.length; i++) {
            if (n[i] == '6') {
                n[i] = '9';
                break;
            }
        }
        return Integer.parseInt(new String(n));

    }
}
