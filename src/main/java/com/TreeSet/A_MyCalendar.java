package main.java.com.TreeSet;

import java.util.Comparator;
import java.util.TreeSet;
/**
 * <a href="https://leetcode.com/problems/my-calendar-i">729. My Calendar I</a></a>
 */
public class A_MyCalendar {

    TreeSet<int[]> events;
    A_MyCalendar(){
        events = new TreeSet<>(Comparator.comparingInt(a -> a[0]));
    }

    public boolean book(int start, int end) {
        int[] newEvent = new int[]{start,end};
        int[] prev = events.floor(newEvent);
        int[] next = events.ceiling(newEvent);
        if((prev==null || prev[1]<= start) && (next==null || end< next[0]))
        {
            events.add(newEvent);
            return true;
        }
        return false;
    }
}
