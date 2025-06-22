package main.java.com.kadaneAndBS;

public class J_MedianOf2SortedArrays {

    /**
     * <a href="https://leetcode.com/problems/median-of-two-sorted-arrays/description/">4. Median of Two Sorted Arrays</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=C2rRzz-JDk8">Video link</a>
     */

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1.length==0)
        {
            return nums2.length%2==0?(nums2[(nums2.length-1)/2]+nums2[(nums2.length)/2])/2:nums2[(nums2.length-1)/2];
        }
        else if(nums2.length==0)
        {
            return nums1.length%2==0?(nums1[(nums1.length-1)/2]+nums1[(nums1.length)/2])/2:nums1[(nums1.length-1)/2];
        }
        double median = 0;
        int medianIndex = ((nums1.length + nums2.length) / 2) ;
        if((nums1.length+nums2.length)%2==0)
            medianIndex-=1;
        int arr1Len = 0;
        int arr2Len = 0;
        int count = 0;

        while (count <= medianIndex && arr1Len < nums1.length && arr2Len < nums2.length) {
            if (nums1[arr1Len] <= nums2[arr2Len]) {

                if (count == medianIndex) {
                    median = nums1[arr1Len];

                }
                arr1Len++;

            } else {

                if (count == medianIndex) {
                    median = nums2[arr2Len];
                }
                arr2Len++;
            }

            count++;

        }
        if ((nums1.length + nums2.length) % 2 == 0) {
            if (arr1Len == nums1.length)
                return (median +nums2[arr2Len])/2;
            else if (arr2Len == nums2.length)
                return (median +nums1[arr1Len])/2;
            else {
                double secondMid = Math.min(nums1[arr1Len], nums2[arr2Len]);
                return (median + secondMid) / 2;
            }

        } else {
            return median;
        }
    }
    public static double findMedianSortedArrays_MergeInto3rdArray(int[] nums1, int[] nums2) {
        int arr1Len = 0;
        int arr2Len = 0;
        int[] mergedArray = new int[nums1.length + nums2.length];
        int count = 0;
        while (arr1Len < nums1.length && arr2Len < nums2.length) {
            if (nums1[arr1Len] <= nums2[arr2Len]) {
                mergedArray[count] = nums1[arr1Len];
                arr1Len++;

            } else {
                mergedArray[count] = nums2[arr2Len];
                arr2Len++;
            }
            count++;
        }
        if (arr1Len == nums1.length) {
            while (arr2Len < nums2.length) {
                mergedArray[count] = nums2[arr2Len];
                count++;
                arr2Len++;
            }
        } else if (arr2Len == nums2.length) {
            while (arr1Len < nums1.length) {
                mergedArray[count] = nums1[arr1Len];
                count++;
                arr1Len++;
            }
        }
        return mergedArray.length%2==0?(double)(mergedArray[(mergedArray.length-1)/2]+mergedArray[(mergedArray.length)/2])/2:mergedArray[(mergedArray.length-1)/2];

    }
    public static void main(String[] args)
    {
        System.out.println(findMedianSortedArrays_MergeInto3rdArray(new int[]{1,2},new int[]{3,4}));
    }
}
