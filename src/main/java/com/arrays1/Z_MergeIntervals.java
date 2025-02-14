package main.java.com.arrays1;

public class Z_MergeIntervals {

    public static int[][] merge(int[][] intervals) {

        int sizeOfAnsArray = intervals.length;

        for(int fixedIntrvl = 0; fixedIntrvl <=intervals.length-2; fixedIntrvl++)
        {
            for(int movingIntrvl=fixedIntrvl+1;movingIntrvl<=intervals.length-1;movingIntrvl++)
            {
                if((intervals[fixedIntrvl][0]<=intervals[movingIntrvl][0] && intervals[movingIntrvl][0]<=intervals[fixedIntrvl][1] )||
                        intervals[movingIntrvl][0]<=intervals[fixedIntrvl][0] && intervals[fixedIntrvl][0]<=intervals[movingIntrvl][1])
                {
                    intervals[movingIntrvl][1] = Math.max(intervals[fixedIntrvl][1], intervals[movingIntrvl][1]);
                    intervals[movingIntrvl][0] = Math.min(intervals[fixedIntrvl][0], intervals[movingIntrvl][0]);
                    intervals[fixedIntrvl][1] = -1; //a sign that this interval is merged
                    sizeOfAnsArray--;
                    break;
                }

                else if( (intervals[fixedIntrvl][0]<=intervals[movingIntrvl][1] && intervals[movingIntrvl][1]<=intervals[fixedIntrvl][1])||
                        (intervals[movingIntrvl][0]<=intervals[fixedIntrvl][1] && intervals[fixedIntrvl][1]<=intervals[movingIntrvl][1]))
                {
                    intervals[movingIntrvl][1] = Math.max(intervals[fixedIntrvl][1], intervals[movingIntrvl][1]);
                    intervals[movingIntrvl][0] = Math.min(intervals[fixedIntrvl][0], intervals[movingIntrvl][0]);
                    intervals[fixedIntrvl][1] = -1; //a sign that this interval is merged
                    sizeOfAnsArray--;
                    break;
                }
                else if( (intervals[fixedIntrvl][0]==intervals[movingIntrvl][0]+1 || intervals[fixedIntrvl][0]+1==intervals[movingIntrvl][0]) &&
                        (intervals[fixedIntrvl][1]==intervals[movingIntrvl][1]+1 || intervals[fixedIntrvl][1]+1==intervals[movingIntrvl][1]) &&
                intervals[fixedIntrvl][0]!=intervals[fixedIntrvl][1])
                {
                    intervals[movingIntrvl][1] = Math.max(intervals[fixedIntrvl][1], intervals[movingIntrvl][1]);
                    intervals[movingIntrvl][0] = Math.min(intervals[fixedIntrvl][0], intervals[movingIntrvl][0]);
                    intervals[fixedIntrvl][1] = -1; //a sign that this interval is merged
                    sizeOfAnsArray--;
                    break;
                }

            }
        }
        int [][] ans = new int[sizeOfAnsArray][2];
        int counterOfAns = 0;
        for(int counter=0;counter<intervals.length;counter++)
        {
            if(intervals[counter][1]!=-1)
            {
                ans[counterOfAns] = intervals[counter];
                counterOfAns++;
            }

        }
        return  ans;
    }
    public static void main(String[] args)
    {
        merge(new int[][]{{2,3},{4,5},{6,7},{8,9},{1,10}});
    }
}
