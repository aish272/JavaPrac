package main.java.com.arrays1;

import java.util.ArrayList;
import java.util.List;

public class W_PascalTriangle {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> pascalTri = new ArrayList<>();
        pascalTri.add(List.of(1));

        for(int counter=1;counter<numRows;counter++)
        {
            List<Integer> newList = new ArrayList<>();
            newList.add(1);
            for(int counter1=0;counter1<pascalTri.get(pascalTri.size()-1).size()-1;counter1++)
            {
                newList.add(pascalTri.get(pascalTri.size()-1).get(counter1)
                                           +
                        pascalTri.get(pascalTri.size()-1).get(counter1+1)
                );
            }
            newList.add(1);
            pascalTri.add(newList);
        }
        return pascalTri;

    }
}
