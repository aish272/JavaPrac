package main.java.com.gfgIMPQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class D_FindKthMinElement2ndMethod {


        static int findKthMinElement(int[] arr, int n, int k,int r) {


            Integer[] integers = IntStream.of( arr ).boxed().toArray( Integer[]::new );
            List<Integer> arrList = new ArrayList<>(Arrays.asList(integers));

            int min = arrList.get(0);
            for(int j=0; j<k;j++) {
                for (int i = 0; i < r ; i++) {
                    if (min > arr[1 + i]) {
                        min = arr[1 + i];
                    }
                }
                arrList.remove(min);


            }

            return min;



        }

    public static void main(String args[])
    {
        int n = 6;
        int[] arr= {7, 10, 4, 3, 20, 15};
        System.out.println(findKthMinElement(arr,n,3, arr.length-1));
    }
}




