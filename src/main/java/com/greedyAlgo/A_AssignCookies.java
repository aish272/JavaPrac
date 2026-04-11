package main.java.com.greedyAlgo;

import java.util.Arrays;

public class A_AssignCookies {
    /**
     * <a href="https://leetcode.com/problems/assign-cookies/description/">455. Assign Cookies</a>
     */
    public int findContentChildren(int[] g, int[] s) {
        int numOfChild=0;
        int cookieAssigned=0;
        Arrays.sort(g);
        Arrays.sort(s);
        for(;numOfChild<g.length&&cookieAssigned<s.length;cookieAssigned++)
        {
            if(g[numOfChild]<=s[cookieAssigned])
            {
                numOfChild++;
            }
        }
        return numOfChild;
    }
}
