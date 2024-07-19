package com.javabasics;

import java.sql.SQLOutput;

public class I_StringMethods {
    public static void main(String[] args)
    {
        String str = "  AISHA  ";
        System.out.println("The length of the string is: "+str.length());
        System.out.println("String in lower case:  "+str.toLowerCase());
        System.out.println("String without spaces: "+str.trim());
        String str2 = "Labyrinth";
        System.out.println("Substring: "+str2.substring(2));
        System.out.println("Substring: "+str2.substring(2,8));
        System.out.println("Substring: "+str2.replace('L','E'));
        System.out.println("Does str2 end with 'e'? "+str2.endsWith("e"));
        System.out.println("Does str2 start with 'L'? "+str2.startsWith("L"));
        System.out.println("Index of 'b' "+str2.indexOf("b"));
        System.out.println("Index of 'b' "+str2.indexOf("b",5));
        System.out.println("Character at: "+str2.charAt(6));
        String str3 = "Hallelujah";
        System.out.println("Last occurrence of l: "+str3.lastIndexOf("l"));
        System.out.println("Last occurrence of l: "+str3.lastIndexOf("l",5));
        System.out.println("Equals or not: "+str3.equals("Halelujah"));
        System.out.println("Equals or not: "+str3.equalsIgnoreCase("hallelujah"));
        String str4 = "  jkjk";
        System.out.println("Index of \"  \" :"+str4.indexOf("  "));

    }
}
