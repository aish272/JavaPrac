package main.java.com.graph1;

import java.util.ArrayList;
import java.util.List;

public class D_DestinationCity {

    /**
     * <a href="https://leetcode.com/problems/destination-city/">1436. Destination City</a>
     */
    public String destCity(List<List<String>> paths) {

        List<String> source = new ArrayList<>();
        List<String> dest = new ArrayList<>();
        for (List<String> path : paths) {
            String s = path.get(0);
            String d = path.get(1);
            source.add(s);
            if (!source.contains(d)) dest.add(d);

            dest.remove(s);
        }
        return dest.get(0);

    }
}
