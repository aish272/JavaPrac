package main.java.com.stacknqueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class J_SubarrayMinimumSum {

    public static int sumSubarrayMins(int[] arr) {
        int min = 0;
        for(int outerLoop=0;outerLoop<arr.length;outerLoop++)
        {
            List <Integer> subArr = new ArrayList<>();
            for(int innerLoop=outerLoop;innerLoop<arr.length;innerLoop++)
            {
                subArr.add(arr[innerLoop]);
                List<Integer>temp = new ArrayList<>(subArr);
                Collections.sort(temp);
                min += temp.get(0);

            }
        }
        return min% 1000000007;

    }
    public static void main(String[] args)
    {
        System.out.println(sumSubarrayMins(new int[]{3,1,2,4}));
    }

}
