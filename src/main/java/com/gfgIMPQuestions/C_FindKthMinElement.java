package main.java.com.gfgIMPQuestions;

public class C_FindKthMinElement {


        static int findKthMinElement(int arr[], int n, int k) {



            for(int j=0;j<k;j++) {
                for (int i = 0; i < n-1; i++) {
                    if (arr[0 + i] < arr[1 + i]) {
                        arr[0 + i] = arr[0 + i] + arr[1 + i];
                        arr[1 + i] = arr[0 + i] - arr[1 + i];
                        arr[0 + i] = arr[0 + i] - arr[1 + i];
                    }
                }
            }
            return arr[n-k];



        }

    public static void main(String args[])
    {
        int n = 6;
        int[] arr= {7, 10, 4, 3, 20, 15};
        System.out.println(findKthMinElement(arr,n,3));
    }
}




