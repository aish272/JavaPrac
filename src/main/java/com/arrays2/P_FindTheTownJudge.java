package main.java.com.arrays2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class P_FindTheTownJudge {

    /**
     * <a href="https://leetcode.com/problems/find-the-town-judge/">997. Find the Town Judge</a>
     */

    public static int findJudge(int n, int[][] trust) {
        if(n==1 && trust.length==0)
            return n;
        if( trust.length==0)
            return -1;
        Set<Integer> peopleWhoTrust = new HashSet<>();
        HashMap<Integer,Integer> map = new HashMap<>(); //measure trustFreq
        for(int[]t : trust)
        {
            peopleWhoTrust.add(t[0]);
            map.put(t[1],map.getOrDefault(t[1],0)+1);
        }
        for(int i =1;i<=n;i++)
        {
            if(!peopleWhoTrust.contains(i))
            {
                if(map.containsKey(i)&&map.get(i)==n-1)
                    return i;
            }
        }
        return -1;

    }
    public static void main(String[] args)
    {
        int[][]arr = new int[][]{{1,2},{2,3}};
        System.out.println(findJudge(3,arr));


    }
}
