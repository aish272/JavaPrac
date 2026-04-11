package main.java.com.bitmanipulation;

public class C_AddBits {


    public static String addBinary(String a, String b) {

        int ans = convertToDec(a) + convertToDec(b);
        return convertToBin(ans);

    }

    private static int convertToDec(String a)
    {
        int multiplier =1;
        int ans =0;
        for(int index=a.length()-1;index>=0;index--)
        {
            int num = a.charAt(index) - '0';
            ans += num*multiplier;
            multiplier *= 2;
        }
        return ans;
    }

    private static String convertToBin(int num)
    {
        StringBuilder binary = new StringBuilder();
        while(num>0)
        {
            binary.append(num%2);
            num = num/2;
        }
        return binary.reverse().toString();

    }

    public static void main(String[] args)
    {
        System.out.println(addBinary("1010","1011"));

}
}
