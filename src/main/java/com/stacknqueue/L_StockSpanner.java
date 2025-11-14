package main.java.com.stacknqueue;

import java.util.ArrayList;
import java.util.List;


/**
 * <a href="https://leetcode.com/problems/online-stock-span/description/">901. Online Stock Span</a>
 */
public class L_StockSpanner {

    List<Integer> data = new ArrayList<>();

    public L_StockSpanner() {

    }

    public int next(int price) {
        data.add(price);
        int span = 0;
        for (int i = data.size() - 1; i >= 0 && data.get(i) <= price; i--) {
            span++;
        }
        return span;
    }
}

/**
 * Your L_StockSpanner object will be instantiated and called as such:
 * L_StockSpanner obj = new L_StockSpanner();
 * int param_1 = obj.next(price);
 */