package com.javabasics;

import java.util.Scanner;

public class G_PracticeSet2 {
    public static void main(String[] args)
    {
        //Q2
        System.out.print("Enter your grade: ");
        Scanner sc = new Scanner(System.in);
        String grade = sc.next();
        char grade1 = grade.charAt(0);
        System.out.println("Decrypted grade: "+(grade1+9));

    }
}
