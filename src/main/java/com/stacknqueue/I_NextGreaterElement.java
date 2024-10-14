package main.java.com.stacknqueue;

import java.util.Scanner;
import java.util.Stack;

public class I_NextGreaterElement {

    public static void nge(int[] arr){
        Stack<Integer> s = new Stack<>();
        int[] nge = new int[arr.length];
        for(int i = arr.length-1;i>=0;i--)
        {
            while(!(s.isEmpty()) && s.peek()<arr[i])
            {
                s.pop();
            }
            if(s.isEmpty())
            {
                nge[i] = -1;
            } else if (s.peek()>arr[i])
            {
                nge[i] = s.peek();
            }
            s.push(arr[i]);
        }
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" "+nge[i]+"\n");
        }
    }

    public static void main(String[] args)
    {
        Scanner s  = new Scanner(System.in);
        int size = 0;
        size = s.nextInt();
        int[] arr = new int[size];
        for(int i=0;i<arr.length;i++)
        {
            arr[i] = s.nextInt();
        }
        s.close();

        nge(arr);
    }
}
