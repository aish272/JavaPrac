package main.java.com.arrays2;

import java.util.HashSet;
import java.util.Set;

public class M_MakeArrayZeroBySubtractingZeroAmt {

    /**
     * <a href="https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/">2357. Make Array Zero by Subtracting Equal Amounts</a>
     * <br/>
     * <a href="https://chatgpt.com/share/69594496-a5e4-8010-af6f-756ebdc90897">ChatGPT solution link</a>
     */
    public int minimumOperations(int[] nums) {

        /**Each operation removes the smallest non-zero value from all non-zero elements
         So the answer = count of distinct non-zero elements

         Key observation (this is the trick)

         Only changes in value matter.

         Each time you subtract:

         You eliminate the current smallest distinct value

         You can never eliminate two different values in one operation

         So:
         👉 One operation per distinct non-zero value */

        Set<Integer> s = new HashSet<>();
        for (int num : nums) {
            if (num != 0)
                s.add(num);
        }
        return s.size();

    }
}
