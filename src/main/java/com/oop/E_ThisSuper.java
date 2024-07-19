package com.oop;

class Base1
{
    int bp;
    Base1(int bp)
    {
        this.bp  = bp;
    }
    public int getBp()
    {
        return bp;
    }

    public int multiply()
    {
        return bp*2;
    }

}

class Derived1 extends Base1
{
    int dp;
    Derived1(int bp, int dp)
    {
        super(bp);
        this.dp = dp;
    }
    public int getDp()
    {
        return  dp;
    }

    @Override
    public int multiply() {
        return dp*7;
    }

    public int getBaseClassProperty()
    {
        return super.getBp();
    }
}
public class E_ThisSuper
{
    protected static void justAMeth()
    {
        System.out.println("Method in E_ThisSuper");
    }
    public static void main(String[] args) {
        Derived1 d1 = new Derived1(7, 9);
        System.out.println("Base property: "+d1.getBaseClassProperty());
        System.out.println("Derived property: "+d1.getDp());
        System.out.println("Derived method: "+d1.multiply());

        Base1 b1= new Derived1(9,8); //base class is reference
        //System.out.println("Calling Derived's method: "+b1.getDp()); will give error.
        System.out.println("Derived method: "+b1.multiply());
    }
}
