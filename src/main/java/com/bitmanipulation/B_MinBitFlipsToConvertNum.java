package main.java.com.bitmanipulation;

public class B_MinBitFlipsToConvertNum {


    /**
     * <a href="https://leetcode.com/problems/minimum-bit-flips-to-convert-number/">2220. Minimum Bit Flips to Convert Number</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=OOdrmcfZXd8&list=PLgUwDviBIf0rnqh8QsJaHyIX7KUiaPUv7&index=3">Video solution link</a>
     */
    public int minBitFlips(int start, int goal) {

        int xor = start^goal;
        int count =0;
        while(xor!=0)
        {
            if(xor%2==1)
            {
                count++;
            }
            xor = xor/2;

        }
        return count;

    }
}
