package main.java.com.string;

public class A_ReverseStringOfWords {

    public static String reverseWords(String s) {

        StringBuilder ans = new StringBuilder();
        String[] words = s.split(" ");
        for(int index = words.length-1;index>=0;index--)
        {

            if(words[index].equals(""))
                continue;
            if(index!=0)
             ans.append(words[index]).append(" ");
            else
                ans.append(words[index]);

        }

        return ans.toString().trim();
    }

    public static void main(String[] args)
    {
        System.out.println(reverseWords("  hello world  "));
    }
}
