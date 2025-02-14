package main.java.com.commonUtilities;

public class A_MergeSort {

    public int[] mergeSortAnArray(int[] arr)
    {
        int arrLength = arr.length;
        if(arrLength<2)
            return arr;
        int mid = arrLength/2;
        int[] arrL = new int[mid];
        int[] arrR = new int[arrLength-mid];
        for(int counter=0;counter<mid;counter++)
        {
            arrL[counter] = arr[counter];
        }
        for (int counter=mid,j=0;counter<arrLength;counter++)
        {
            arrR[j] = arr[counter];
            j++;
        }
        mergeSortAnArray(arrL);
        mergeSortAnArray(arrR);
        return sort2ArraysAndJoinInAscendingOrder(arrL,arrR,arr);
    }

    public int[] sort2ArraysAndJoinInAscendingOrder(int[] leftArray, int[] rightArray, int[] supersetArray)
    {
        int leftArrayLen = 0;
        int rightArrayLen = 0;
        int mainArrayLen = 0;
        while (leftArrayLen<leftArray.length&&rightArrayLen<rightArray.length)
        {
            if(leftArray[leftArrayLen]<rightArray[rightArrayLen])
            {
                supersetArray[mainArrayLen] = leftArray[leftArrayLen];
                leftArrayLen++;
                mainArrayLen++;
            }
            else
            {
                supersetArray[mainArrayLen] = rightArray[rightArrayLen];
                rightArrayLen++;
                mainArrayLen++;
            }
        }
        while (leftArrayLen<leftArray.length)
        {
            supersetArray[mainArrayLen]= leftArray[leftArrayLen];
            leftArrayLen++;
            mainArrayLen++;
        }
        while (rightArrayLen<rightArray.length)
        {
            supersetArray[mainArrayLen] = rightArray[rightArrayLen];
            rightArrayLen++;
            mainArrayLen++;
        }
        return supersetArray;
    }
}
