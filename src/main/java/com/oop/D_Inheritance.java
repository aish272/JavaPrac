package com.oop;

class Base
{
    int baseProperty;
    public void setBaseProperty(int baseProperty)
    {
        this.baseProperty = baseProperty;
    }
    public int getBaseProperty()
    {
        return baseProperty;
    }
}

class Derived extends Base
{
    int derivedProperty;
    public void setDerivedProperty(int DerivedProperty)
    {
        this.derivedProperty = DerivedProperty;
    }
    public int getDerivedProperty()
    {
        return derivedProperty;
    }
}
public class D_Inheritance
{
    public static void main(String[] main)
    {
        Base b1 = new Base();
        b1.setBaseProperty(65);
        System.out.println("Value of base property: "+b1.getBaseProperty());

        Derived d1 = new Derived();
        d1.setBaseProperty(9);
        d1.setDerivedProperty(89);
        System.out.println("Value of base property: "+d1.getBaseProperty());
        System.out.println("Value of derived property: "+d1.getDerivedProperty());
    }
}
