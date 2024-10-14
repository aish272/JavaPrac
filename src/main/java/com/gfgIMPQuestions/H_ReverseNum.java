package main.java.com.gfgIMPQuestions;

public class H_ReverseNum {

    public static void main(String[] args)
    {
        int num = 12378;
        int rev = 0;
        while(num!=0)
        {
            rev = rev*10 + num%10;
            num = num/10;
        }
        System.out.println(rev);
    }
}
