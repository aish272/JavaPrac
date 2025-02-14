package main.java.com.arrays1;

public class Q_StockBuySell {
    public int maxProfit(int[] prices) {

        int cost = 0;
        int min = prices[0];
        for(int index=1;index<prices.length;index++)
        {
            cost = Math.max(prices[index]-min,cost);
            min = Math.min(prices[index],min);

        }
        return cost;
    }
}
