package main.java.com.priorityqueue;

import java.util.PriorityQueue;

public class J_MaxScoreByTurningStones {


    /**
     * <a href="https://leetcode.com/problems/maximum-score-from-removing-stones/">1753. Maximum Score From Removing Stones</a>
     */
    public int maximumScore(int a, int b, int c) {

        PriorityQueue<Integer> min = new PriorityQueue<>();

        min.add(a);
        min.add(b);
        min.add(c);

        a = min.poll();
        b = min.poll();
        c = min.poll();

        int points = 0;

        //Smallest = a
        //2nd = b
        //Largest = c

        //Make b and c equal and then reduce them till one of them becomes zero

        if (a == c - b) { //a is equal to b and c diff.
            points += a;
            c -= a;

            points += c ; //b and c both are equal now, so can add either of them to the sum
            return points;

        } else if (a > c - b) {
            points += c - b; // a is bigger than the diff. Reduce a equal to the diff.
            a -= (c - b);
            c -= (c - b);

            int a1 = a / 2; //divide a to 2 parts and then reduce equally from both b and c
            if (c - a1 >= 0) {
                c = c - a1;
                b = b - a1;
                points += (a1 * 2);
            } else {
                points += a; // else add a to the points and return. (c+b >= a)
                return points;
            }
            if (a % 2 == 1 && c > 0)

            {
                c--; // a/2 was odd then reduce one more time
                points++;
            }

            while (c > 0 && b > 0) { //keep reducing till one of them is 0
                c--;
                b--;
                points++;
            }

        } else {
            points += a;  // a is less than the diff. Add 'a' to points
            c -= a; //reduce from c
            points += Math.min(b,c); //add whatever is lesser
            return points;
        }

        return points;

    }
}
