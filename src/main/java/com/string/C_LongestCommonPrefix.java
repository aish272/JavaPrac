package main.java.com.string;

public class C_LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==1)
            return strs[0];
        String ans = "";
        String commonString = strs[0];
        for(int index =1; index<strs.length;index++)
        {
            int lenCommon = 0;
            ans = "";
            while(lenCommon<commonString.length() && lenCommon<strs[index].length())
            {
                if(commonString.split("")[lenCommon].equals(strs[index].split("")[lenCommon]))
                {
                    ans = ans+commonString.split("")[lenCommon];
                    lenCommon++;
                }
                else
                {
                    break;
                }
            }
            commonString = ans;
        }
        return ans;

    }
    public static void  main(String[] args)
    {
        System.out.println(longestCommonPrefix(new String[]{"aaa","aa","aaa"}));
    }
}
