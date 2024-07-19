package com.oop;

class Shape
{
    int len, breadth, side;
    char type;
    Shape(char type, int len, int breadth)
    {
        this.type = type;
        this.len =len;
        this.breadth = breadth;
    }
    Shape(char type, int side )
    {
        this.type = type;
        this.side = side;
    }

    public int calcArea()
    {
        if(type=='S')
        {
            return side*side;
        }
        else if(type=='R')
        {
          return len*breadth;
        }
        else
            return -1;
    }
}
public class B_PracticeSet8 {

    public  static  void main (String[] args) {
        Shape sq = new Shape('S', 8);
        System.out.println("The area is: "+sq.calcArea());
        System.out.println(sq.type+" "+sq.side);
    }


}
