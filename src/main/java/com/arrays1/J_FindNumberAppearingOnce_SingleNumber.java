package main.java.com.arrays1;

public class J_FindNumberAppearingOnce_SingleNumber {


    public int singleNumber(int[] a) {
        int xor = a[0];
        for(int counter=1;counter<a.length;counter++)
        {
            xor = xor^a[counter];
        }
        return xor;
    }
    public static void main(String[] args) {
    }

}
