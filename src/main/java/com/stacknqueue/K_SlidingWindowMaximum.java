package main.java.com.stacknqueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class K_SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] ans = new int[n-k+1];
        int ansIndex = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for(int index=0;index<n;index++)
        {
            if(!q.isEmpty() && q.peekFirst()==index-k)
            {
                q.pollFirst();
            }
            while(!q.isEmpty() && nums[q.peekLast()]<nums[index])
            {
                q.pollLast();
            }
            q.addLast(index);
            if(index>=k-1)
            {
                ans[ansIndex++] = nums[q.peek()];
            }
        }
        return ans;

    }

}
