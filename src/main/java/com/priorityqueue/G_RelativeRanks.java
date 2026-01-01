package main.java.com.priorityqueue;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class G_RelativeRanks {

    /**
     * <a href="https://leetcode.com/problems/relative-ranks/">506. Relative Ranks</a>
     */
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int s : score)
        {
            pq.add(s);
        }
        HashMap<Integer,String> map = new HashMap<>();
        map.put(pq.poll(),"Gold Medal");
        if(pq.size()>=1)
        {
            map.put(pq.poll(),"Silver Medal");
        }
        if(pq.size()>=1)
        {
            map.put(pq.poll(),"Bronze Medal");
        }
        int rank = 4;
        while(!pq.isEmpty())
        {
            int val = pq.poll();
            map.put(val,String.valueOf(rank));
            rank++;
        }
        String[] ans = new String[score.length];
        for(int i=0;i<ans.length;i++ )
        {
            ans[i] = map.get(score[i]);
        }
        return ans;

    }
}
