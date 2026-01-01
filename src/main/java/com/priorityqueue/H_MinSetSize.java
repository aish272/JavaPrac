package main.java.com.priorityqueue;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class H_MinSetSize {

    /**
     * <a href="https://leetcode.com/problems/reduce-array-size-to-the-half/">1338. Reduce Array Size to The Half</a>
     */
    public int minSetSize(int[] arr) {

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : arr)
        {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.addAll(map.values());
        int sum =0;
        int count = 0;
        while(!pq.isEmpty())
        {
            sum += pq.poll();
            count++;
            if(sum>=(arr.length/2))
            {
                return count;
            }
        }
        return count;


    }
}
