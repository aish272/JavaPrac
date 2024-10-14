package main.java.com.oop;
/**

@author Aishwarya
 */
abstract class Laptop
{
    abstract public void os(String osName);
    abstract void touchScreen(Boolean isTouchScreen);
    abstract void ram(int RAM);
    int x=89;
    void notAbstractMethod()
    {
        System.out.println("This method is not abstract but a part of abstract class.");
    }
}
class HP_Pavilion extends Laptop
{
    public void os(String OsName)
    {
        System.out.println("OS: "+OsName);
    }
    void touchScreen(Boolean isTouchScreen)
    {
        System.out.println("Is TouchScreen: "+isTouchScreen);
    }
    public void ram(int RamAvailable)
    {
        System.out.println("Ram: "+RamAvailable);
    }
}

abstract class MacBook extends Laptop
{
    abstract public void touchBar(Boolean hasTouchBar);
}

class MacBookM1Air512 extends MacBook
{
    @Override
    public void os(String OSName)
    {
        System.out.println("OS is:"+OSName);
    }
    void touchScreen(Boolean isTouchScreen)
    {
        System.out.println("Is System TouchScreen: "+isTouchScreen);
    }
    public void ram(int RamInMac)
    {
        System.out.println("Ram Available: "+RamInMac);
    }
    public void touchBar(Boolean TouchBar)
    {
        System.out.println("Has TouchBar: "+TouchBar);
    }
    int x = 9999;
}
public class F_AbstractClass
{
    public static void main(String[] args)
    {
        Laptop myMac = new MacBookM1Air512();
        System.out.println("Checking which x will be printed: "+myMac.x); // This will print Laptop's x.
        //myMac.touchBar(false); // won't run method not defined abstract class Laptop and reference is Laptop.
        myMac.ram(8);
        HP_Pavilion oldDevice  = new HP_Pavilion();
        oldDevice.os("Windows");
        oldDevice.notAbstractMethod();
    }
}
