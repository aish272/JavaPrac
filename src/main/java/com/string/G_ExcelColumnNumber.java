package main.java.com.string;

public class G_ExcelColumnNumber {
    public int titleToNumber(String s) {
        int sum =0;

        for(int counter =s.length()-1;counter>=0;counter--)
        {
            int charCode = s.charAt(counter)-64;
            sum+=Math.pow(26,s.length()-counter-1)*charCode;
        }
        return sum;
    }
}
