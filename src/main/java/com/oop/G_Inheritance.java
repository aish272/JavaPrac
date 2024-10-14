package main.java.com.oop;

interface HouseBasic
{
    void getBHK(int bhk);
    void getKitchenType(boolean isModular);
    float price = 2.5f;
}

interface HouseAdvanced extends HouseBasic
{
    void hasPool(boolean hasPool);
    void hasTheatre(boolean hasTheatre);
    float FurnishingPrice = 0.5f;
}

abstract class HouseLocality
{
    void isInCity(String City)
    {
        System.out.println("The house is in "+City);
    }
    abstract void hasAParkNearby(boolean hasParkNearby);
}
class House extends HouseLocality implements HouseBasic, HouseAdvanced
{
    public void getBHK(int BHK)
    {
        System.out.println(BHK+" BHK House");

    }
    public void getKitchenType(boolean isModular)
    {
        System.out.println("Is kitchen modular: "+isModular);
    }

    public void hasPool(boolean hasPool)
    {
        System.out.println("Has a pool: "+hasPool);
    }
    public void hasTheatre(boolean hasATheatre)
    {
        System.out.println("Has a theatre: "+hasATheatre);
    }
    public void hasAParkNearby(boolean hasParkNearby)
    {
        System.out.println("Has a park nearby: "+hasParkNearby);
    }
}

public class G_Inheritance
{
    public static void main(String[] args)
    {
        HouseBasic myHouse = new House();
        myHouse.getBHK(7);
        /*
          The object has a referral of HouseAdvanced but the method is declared in HouseBasic.
          This is not giving an error because HouseAdvanced is extending (not implementing.
          interface can't implement another interface) HouseBasic.
         */
        HouseAdvanced myHome = new House();
        myHome.getKitchenType(true);
    }

}
