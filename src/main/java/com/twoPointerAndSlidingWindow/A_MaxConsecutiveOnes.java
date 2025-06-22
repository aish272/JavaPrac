package main.java.com.twoPointerAndSlidingWindow;

public class A_MaxConsecutiveOnes {

    public static int longestOnesBrute(int[] nums, int k) {
        int maxLen =0;
        for(int i =0; i<nums.length;i++)
        {
            int zerosCount =0;
            for(int j =i; j<nums.length;j++)
            {
                if(zerosCount==k&&nums[j]==0) {
                    maxLen = Math.max(maxLen, (j-i));
                    break;
                }
                if(nums[j]==0&&zerosCount<k)
                {
                    zerosCount++;
                }

            }
        }
        return maxLen;
    }

    public static int longestOnesBetter(int[] nums, int k) {
        int maxLen =0;
        int leftPointer =0;
        int rightPointer= 0;
        int zerosLen=0;
        while(rightPointer<nums.length)
        {

            if(nums[rightPointer]==0)
            {
                zerosLen++;
            }
            if(zerosLen>k)
            {

                while(nums[leftPointer]!=0)
                {
                    leftPointer++;
                }
                leftPointer++;
                zerosLen--;
            }
            else
            {
                maxLen = Math.max(maxLen, (rightPointer-leftPointer+1));
            }
            rightPointer++;

        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestOnesBetter(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1},3));

    }
}
