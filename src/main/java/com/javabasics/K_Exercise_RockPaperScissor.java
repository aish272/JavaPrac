package com.javabasics;

import java.util.Random;
import java.util.Scanner;

public class K_Exercise_RockPaperScissor
{
    public static void main(String[] args)
    {
        Random RandNum = new Random();
        int Botchoice = RandNum.nextInt(3);
        System.out.println("Enter 0 for paper.\nEnter 1 for scissor.\nEnter 2 for rock. ");
        Scanner sc = new Scanner(System.in);
        byte choice = sc.nextByte();
        if((Botchoice==0 && choice==1) || (Botchoice==1 && choice==2) || (Botchoice==2&& choice==0))
        {
            System.out.println("You Won!");
        }
        else if ((Botchoice==0 && choice==2) || (Botchoice==1 && choice==0) || (Botchoice==2&& choice==1))
        {
            System.out.println("You Lost!");
        }
        else if ((Botchoice==0 && choice==0) || (Botchoice==1 && choice==1) || (Botchoice==2&& choice==2))
        {
            System.out.println("Draw");
        }
        else
        {
            System.out.println("Invalid input. Enter 0, 1 or 2");
        }
        System.out.println("Bot's Choice: "+Botchoice);

    }
}
