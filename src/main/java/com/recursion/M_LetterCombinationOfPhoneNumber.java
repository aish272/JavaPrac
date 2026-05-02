package main.java.com.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M_LetterCombinationOfPhoneNumber {

    /**
     * <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number/">17. Letter Combinations of a Phone Number</a>
     */
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<Character, String>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String> ans = new ArrayList<>();
        returnCombo(digits, 0, new StringBuilder(), map, ans);
        return ans;
    }

    public void returnCombo(String digits, int index, StringBuilder combo, Map<Character, String> map, List<String> ans)
    {
        if(index==digits.length())
        {
            ans.add(combo.toString());
            return;
        }

        for(int i =0; i< map.get(digits.charAt(index)).length(); i++)
        {
            combo.append(map.get(digits.charAt(index)).charAt(i));
            returnCombo(digits, index+1, combo, map, ans);
            combo.deleteCharAt(combo.length()-1);
        }

    }
}
