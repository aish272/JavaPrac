package main.java.com.gfgIMPQuestions;

public class B_FindMaxMin {


        static int findMinMaxInArray(int arr[], int n) {


            int max = arr[0];
            int min=arr[0];
            for(int i=1;i<n;i++)
            {
                if(max<arr[i])
                    max = arr[i];
                else if(min>arr[i])
                    min=arr[i];
            }
            return max+min;



        }

    public static void main(String args[])
    {
        int n = 5;
        int[] arr= {-1, -2, -3, -4, -5};
        System.out.println(findMinMaxInArray(arr,n));
    }
}




