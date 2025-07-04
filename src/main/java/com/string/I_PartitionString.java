package main.java.com.string;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class I_PartitionString {

    /**
     * <a href="https://leetcode.com/problems/partition-string/description/">3597. Partition String </a>
     */
    public static List<String> partitionString(String s) {

        int count = 0;
        Set<String> ans = new LinkedHashSet<>();
        StringBuilder s1 = new StringBuilder();
        while (count < s.length()) {
            s1.append(s.charAt(count));
            if (!ans.contains(s1.toString())) {
                ans.add(s1.toString());
                s1.delete(0,s1.length());
            }
            count++;
        }
        return ans.stream().toList();
    }

    public static void main(String[] args)
    {
        System.out.println(partitionString("abbccccd"));
    }
}
