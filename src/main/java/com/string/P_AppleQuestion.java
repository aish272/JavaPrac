package main.java.com.string;

public class P_AppleQuestion {

    public static String returnFactorisedString(String str1, String str2)
    {
        int index1 = 0;
        int index2 = str2.length()-1;
        while(index1<str1.length() && index2>=0)
        {
            String s1 = str1.substring(0,index1+1);
            String s2 = str2.substring(index2);

            if(s1.equals(s2))
            {

                break;
            }
            index1++;
            index2--;
        }
        int index3 = str1.length()-1;
        int index4 = 0;
        while(index4<str2.length() && index3>=0)
        {
            String s1 = str1.substring(index3);
            String s2 = str2.substring(0,index4+1);

            if(s1.equals(s2))
            {

                break;
            }
            index4++;
            index3--;
        }
        if(index1>index4)
        {
            return str2+str1.substring(index1+1);
        }
        else
        {
            return str1+str2.substring(index4+1);
        }

    }

    public static void main(String[] args)
    {
        System.out.println(returnFactorisedString("abcpooop1234","1234popabc"));
    }
}
