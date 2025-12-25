package main.java.com.arrays2;

public class J_Third_maximum_number {

    /**
     * <a href="https://leetcode.com/problems/third-maximum-number/">414. Third Maximum Number</a>
     */
    public static int thirdMax(int[] nums) {

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        boolean assigned = false;
        for (int i : nums) {
            if (i > first) {

                third = second;
                second = first;
                first = i;
                if(third!= Integer.MIN_VALUE)
                {
                    assigned = true;
                }
            } else if (i < first && i > second) {
                third = second;
                second = i;
                if(third!= Integer.MIN_VALUE)
                {
                    assigned = true;
                }
            } else if ((i < second && i > third) || (i==Integer.MIN_VALUE && third ==Integer.MIN_VALUE)) {
                assigned = true;
                third = i;
            }
        }

        return  assigned && second!= Integer.MIN_VALUE ?  third : first;

    }
    public static void main(String[] args)
    {
        int[]arr = new int[]{1,2,2,5,3,5};
        System.out.println(thirdMax(arr));


    }
}
