package com.javabasics;

public class E_Operators {
    public static void main(String[] args)
    {
        float f1 = 8.9f;
        System.out.println("8.9 % 6.7 "+ (float) (f1%6.7));

        f1 += 8;
        System.out.println("New value of f1 "+f1);

        //Relational Operator

        boolean b1 = 8>9;
        System.out.println("8>9: "+b1);

        //logical operators

        boolean b2 = (90>0) && (78==90) || (89>90);
        System.out.println("Result: "+b2);

        //bitwise operator

        System.out.println(1<<9); //0001 (1) -> 1000000000 (512) Shifted 1 to the left by 9 places.
        System.out.println(9>>1); //1001 (9) -> 0100(4)

    }
}
