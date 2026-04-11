package main.java.com.priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class I_TakeGiftsFromRichestPile {

    /**
     * <a href="https://leetcode.com/problems/take-gifts-from-the-richest-pile/description/">2558. Take Gifts From the Richest Pile</a>
     */

    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long ans = 0;
        for(int gift: gifts)
        {
            pq.add(gift);
        }
        for(int i =0;i<k;i++)
        {
            long newGift = (long)Math.floor(Math.sqrt(pq.peek()));
            pq.poll();
            pq.add((int)newGift);

        }
        while(!pq.isEmpty())
        {
            ans+=pq.poll();
        }
        return ans;

    }
}
