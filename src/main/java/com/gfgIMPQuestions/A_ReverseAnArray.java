package main.java.com.gfgIMPQuestions;

import java.util.List;

public class A_ReverseAnArray {


        void reverseSubArray(int arr[], int n, int l, int r) {


            l=l-1;
            r=r-1;
            int limit = ((r-l)/2);
            if((r-l)%2==1)
                limit=limit+1;


            for (int i=0;i<limit;i++)
            {
                arr[l+i] = arr[l+i] +arr[r-i];
                arr[r-i] = arr[l+i] - arr[r-i];
                arr[l+i] = arr[l+i] - arr[r-i];

            }
            System.out.println(List.of(arr));



        }

    public static void main(String args[])
    {
        int n = 5;
        int[] arr= {1, 2, 3, 4, 5};
        int L = 2, R = 5;
        new A_ReverseAnArray().reverseSubArray(arr,n,L,R);
    }
}




