package main.java.com.priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class F_LastStoneWeight {

    /**
     * <a href="https://leetcode.com/problems/last-stone-weight/description/">1046. Last Stone Weight</a>
     */
    public int lastStoneWeight(int[] stones) {

        if(stones.length==1)
            return stones[0];

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int num : stones)
        {
            pq.add(num);
        }
        while(pq.size()>1)
        {
            int diff = Math.abs(pq.poll()-pq.poll());
            if(diff>0)
            {
                pq.add(diff);
            }
        }
        return pq.isEmpty()?0:pq.poll();


    }
}
