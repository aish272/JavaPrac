package main.java.com.dp;

public class A_Fibonacci {

    public int fibRecursion(int n) {
        if(n<=1)
            return n;
        else
            return fibRecursion(n-1)+fibRecursion(n-2);

    }
    public static int fibDP(int n, int[] dpArr) {
        if (n == 0) return 0;
        else if (dpArr[n] != 0) {
            return dpArr[n];
        }
        else return dpArr[n] = fibDP(n - 1, dpArr) + fibDP(n - 2, dpArr);

    }

    public static int fibTabulation(int n)
    {
        if(n<=1)
            return n;
        int grandF = 0;
        int father = 1;
        for(int i = 2;i<=n;i++)
        {
           int current = grandF+father;
           grandF = father;
           father = current;
        }
        return father;
    }

    public static void main(String[] arg) {
        int n = 7;
        int[] dpArr = new int[n + 1];
        dpArr[0] = 0;
        dpArr[1] = 1;
        System.out.println(fibDP(n, dpArr));
        System.out.println(fibTabulation(8));
    }


}
