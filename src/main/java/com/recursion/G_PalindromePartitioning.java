package main.java.com.recursion;

import java.util.ArrayList;
import java.util.List;

public class G_PalindromePartitioning {
    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        partitionPalindromes(ans,new ArrayList<>(),0,s);
        return ans;
    }

    public static void partitionPalindromes(List<List<String>> ans, List<String> partition, int index, String s)
    {
        if(index==s.length())
        {
            ans.add(new ArrayList<>(partition));
        }
        for(int count=index;count<s.length();count++)
        {
            if(isPalindrome(s,index,count))
            {
                partition.add(s.substring(index,count+1));
                partitionPalindromes(ans,partition,count+1,s);
                partition.remove(partition.size()-1);
            }
        }
    }

    public static boolean isPalindrome(String s, int start, int end)
    {
        while(start<=end)
        {
            if(s.charAt(start)!=s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(partition("aaabbb"));

    }
}
