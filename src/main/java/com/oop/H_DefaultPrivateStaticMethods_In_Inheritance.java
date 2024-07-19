package com.oop;

interface Calc
{
    default void add(int a, int b)
    {
        System.out.println("The default method output: "+(a+b));
        mult(a,b); //private
        div(a,b);  //static
        square(a); //private static
    }
    private void mult(int a, int b)
    {
        System.out.println("The private method output: "+(a*b));
    }
    static void div(int a, int b)
    {
        float result = a/b;
        System.out.println("The static method output: "+(a/b));
        //add(); //Non-static method 'add(int, int)' cannot be referenced from a static context
    }
    private static void square(int n)
    {
        System.out.println("The private static method output: "+(n*n));
    }
    /**
    default static void cube()
    {
        //Illegal combination of modifiers default and static.
    }

     */

    default void cube(int n)
    {
        System.out.println("Result from default method: "+(n*n*n));
    }
}

class CalcMethods implements Calc
{
    @Override
    public void cube(int n)
    {
        System.out.println("The method must mandatorily be public. ");
        System.out.println("The result from overridden method is:  "+(n*n*n));
    }

}
public class H_DefaultPrivateStaticMethods_In_Inheritance
{
    public static void main(String[] args)
    {
        CalcMethods c1 = new CalcMethods();
        c1.cube(5);
        c1.add(8,6);
        Calc c2 = new CalcMethods();
        c2.cube(8);
    }
}
