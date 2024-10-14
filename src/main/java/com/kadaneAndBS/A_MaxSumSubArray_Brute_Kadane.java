package main.java.com.kadaneAndBS;

import org.jetbrains.annotations.NotNull;

public class A_MaxSumSubArray_Brute_Kadane {

   public static void printMaxSumInASubArrayBruteForce(int[] nums)
   {
       int maxSum = Integer.MIN_VALUE;
       int trackSum;
       int startIndex = 0;
       int endIndex = 0;
       for(int i = 0; i< nums.length; i++)
       {
           trackSum = nums[i];
           if(maxSum<trackSum)
           {
               maxSum=trackSum;
               startIndex = i;
           }
           for(int j = i; j< nums.length-1; j++)
           {
               trackSum = trackSum + nums[j+1];
               if(maxSum<trackSum)
               {
                   maxSum=trackSum;
                   startIndex = i;
                   endIndex = j+1;
               }


           }
       }
       System.out.println("MaxSum:"+maxSum);
       System.out.println("StartIndex:"+startIndex);
       System.out.println("EndIndex:"+endIndex);
   }

   public static int returnMaxSubArrayUsingKadane(int @NotNull [] nums)
   {
       int max = Integer.MIN_VALUE;
       int sum = 0;
       int endindex=0;
       int startIndex=0;
       for(int i=0;i<nums.length;i++)
       {

           sum += nums[i];
           if(sum>max)
           {

               max = sum;
               endindex = i;
           }
           if(sum<0)
           {
               sum= 0;
               startIndex = i+1;
           }

       }
       System.out.println("start"+startIndex);
       System.out.println("emd"+endindex);
       return max;
   }

   public static void main(String[] args)
   {
       int[] arr1 = {-2,-3,4,-1,-2,1,5,-3};
       printMaxSumInASubArrayBruteForce(arr1);
       System.out.println(returnMaxSubArrayUsingKadane(arr1));

   }
}
