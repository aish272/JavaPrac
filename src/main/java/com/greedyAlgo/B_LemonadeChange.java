package main.java.com.greedyAlgo;

public class B_LemonadeChange {

    /**
     * <a href="https://leetcode.com/problems/lemonade-change/description/">860. Lemonade Change</a>
     */
    public boolean lemonadeChange(int[] bills) {
        int numOf5bill = 0;
        int numOf10bill = 0;
        boolean changeProcessed = true;
        for(int bill:bills)
        {
            switch (bill)
            {
                case 5->
                {
                    numOf5bill++;
                }
                case 10 ->
                {
                    numOf10bill++;
                    if(numOf5bill>=1)
                    {
                        numOf5bill--;
                    }
                    else
                    {
                        changeProcessed = false;
                    }
                }
                case 20 ->
                {

                    if(numOf5bill>=1 && numOf10bill>=1)
                    {
                        numOf5bill--;
                        numOf10bill--;
                    } else if (numOf5bill>=3) {
                        numOf5bill -=3;
                    } else
                    {
                        changeProcessed = false;
                    }
                }
            }
            if( !changeProcessed)
                return false;
        }
        return true;
    }
}
