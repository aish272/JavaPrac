package main.java.com.arrays2;

import java.util.Arrays;

public class A_Merge2SortedArraysWithoutExtraSpace {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int num1Len =0;
        int num2Len2 = 0;

        while(num1Len<nums1.length-n && num2Len2<n)
        {
            if(nums1[m-num1Len-1]>nums2[num2Len2])
            {
                int temp = nums1[m-num1Len-1];
                nums1[m-num1Len-1] = nums2[num2Len2];
                nums2[num2Len2] = temp;
                num1Len++;
                num2Len2++;
            }
            else
            {
                break;
            }
        }
        Arrays.sort(nums1,0,m);
        Arrays.sort(nums2,0,n);
        int counter =m;
        num2Len2 = 0;
        while (num2Len2<n)
        {
            nums1[counter] = nums2[num2Len2];
            counter++;
            num2Len2++;
        }

    }
    public static void main(String[] args)
    {
        merge(new int[]{2,4,6,0,0,0},3,new int[]{1,3,5},3);
    }
}
