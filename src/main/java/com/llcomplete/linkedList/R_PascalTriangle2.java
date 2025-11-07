package main.java.com.llcomplete.linkedList;

import java.util.ArrayList;
import java.util.List;

public class R_PascalTriangle2 {

    /**
     * <a href="https://leetcode.com/problems/pascals-triangle-ii/description/">119. Pascal's Triangle II</a>
     */

    public static List<Integer> getRow(int rowIndex) {

        List<Integer> current = new ArrayList<>();
        current.add(1);
        int row = 0;
        while(row!=rowIndex)
        {
            List<Integer> temp = new ArrayList<>();
            temp.add(current.get(0));
            for(int index=1;index<current.size();index++)
            {
                temp.add(current.get(index-1)+current.get(index));
            }
            temp.add(current.get(current.size()-1));
            row++;
            current.clear();
            current.addAll(temp);
        }
        return current;
    }

    public static void main(String[] args) {

        System.out.println(getRow(3));
    }


}
