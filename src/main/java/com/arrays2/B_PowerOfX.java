package main.java.com.arrays2;

public class B_PowerOfX {
    public double myPowIterative(double x, int n) {
        double ans = 1;
        if(n==0)
            return 1;
        if (n >= 1) {
            while (n > 0) {
                ans *= x;
                n--;
            }
            return ans;
        } else {
            while (n < 0) {
                ans *= x;
                n++;
            }
            return 1 / ans;
        }
    }

    public static double myPowRecursive(double x, int n) {
        double ans = 1;
        if(n>=0)
            return multiplication(ans,x,n);
        else
            return division(ans,x,n);
    }

    public static double multiplication(double ans, double x, int n)
    {
        if (n==0)
            return ans*1;
        else {
            ans = ans * x;
            n--;
        }
        return multiplication(ans,x,n);
    }

    public static double division(double ans, double x, int n)
    {
        if(n==0)
            return 1/ans ;
        else {
            ans = ans * x;
            n++;
        }
        return division(ans,x,n);

    }

    public double myPowOptimal(double x, int n) {
        double ans =1;
        double n2 = (double) n;
        if(n>=0)
            return multi(ans,x,n);
        else {
            n2 = n2 * n2;
            n2 = Math.sqrt(n2);
            return 1 / (multi(ans, x, n2));
        }
    }
    public static double multi(double ans, double x, double n)
    {
        if(n==0)
        {
            return ans*1;
        }
        else if(n%2==1)
        {
            ans = ans*x;
            n--;
        }
        else
        {
            n = n/2;
            x = x*x;
        }
        return multi(ans,x,n);

    }

    public static void main(String[] args)
    {
        //System.out.println(myPowOptimal(2,-200000000));

    }

}
