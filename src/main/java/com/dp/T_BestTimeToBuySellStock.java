package main.java.com.dp;

public class T_BestTimeToBuySellStock {

    /**
     * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/">122. Best Time to Buy and Sell Stock II</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=nGJmxkUJQGs">Video solution link</a>
     */

    public int maxProfit(int[] prices) {
        return returnMaxProfit(prices, 1, 0);
    }

    public int returnMaxProfit(int[] prices, int canBuy, int index) {
        if (index == prices.length) {
            return 0;
        }
        int profit = 0;
        int profit1 = 0;
        if (canBuy == 1) //can buy
        {
            profit = -prices[index] + returnMaxProfit(prices, 0, index + 1); //bought and can sell at next index
            profit1 = 0 + returnMaxProfit(prices, 1, index + 1); //not bought and can not sell at next index
        } else // can sell
        {
            profit = prices[index] + returnMaxProfit(prices, 1, index + 1); //sold and can buy at next index
            profit1 = 0 + returnMaxProfit(prices, 0, index + 1); //not sold and can not buy at next index
        }
        return Math.max(profit, profit1);

    }


}
