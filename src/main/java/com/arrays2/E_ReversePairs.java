package main.java.com.arrays2;

public class E_ReversePairs {

    public int reversePairs(int[] nums) {
        int ansCount =0;
        for (int outerCounter = 0; outerCounter < nums.length-1; outerCounter++) {
            for (int innerCounter = outerCounter+1; innerCounter < nums.length; innerCounter++) {
                if((long)nums[outerCounter]>(long)2*nums[innerCounter])
                    ansCount++;
            }
        }
        return ansCount;
    }
}
