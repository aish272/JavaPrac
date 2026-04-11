package main.java.com.string;

public class F_ReverseDegreeOfString {
    public int reverseDegree(String s) {
        int sum =0;

        for(int counter =1;counter<=s.length();counter++)
        {
            int charCode = s.charAt(counter-1);
            int pos = charCode-97+1;
            int reversePos = 26-pos+1;
            sum+= counter*reversePos;
        }
        return sum;
    }
}
