package main.java.com.arrays1;

public class A_SecondLargestElement {


    public static int getSecondLargest(int[] arr) {

        int largestNum = arr[0];
        int secondLargestNum = arr[0];
        for(int i=1; i<arr.length; i++)
        {
            if(arr[i]>largestNum)
            {
                secondLargestNum  = largestNum;
                largestNum = arr[i];

            }
            if(arr[i]>secondLargestNum && arr[i]<largestNum)
            {
                secondLargestNum = arr[i];
            }
        }
        return secondLargestNum;

    }

    public static void main(String[] args)
    {
        System.out.println(getSecondLargest(new int[]{12, 35, 1, 10, 34, 36}));
    }
}
