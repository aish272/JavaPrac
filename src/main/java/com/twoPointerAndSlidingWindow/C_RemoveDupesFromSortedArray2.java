package main.java.com.twoPointerAndSlidingWindow;

public class C_RemoveDupesFromSortedArray2 {

    public static int removeDuplicates(int[] nums) {

        int countOfDupes = 0;
        for(int i=0;i<nums.length;)
        {
            int num = nums[i];
            int counter = 0;
            while(i< nums.length && num==nums[i])
            {
                counter++;

                if(counter>2)
                {
                    nums[i] = 100000; //marking dupe more than 2
                    countOfDupes++;

                }
                i++;
            }
        }
        int left = 0;
        int right = 0;
        while(left<(nums.length-countOfDupes))
        {

            if(nums[left]==100000&&nums[right]!=100000)
            {
                nums[left] = nums[right];
                nums[right] = 100000;
                left++;
            }
            if(nums[left]!=100000)
            {
                left++;
            }
            right++;

        }

        return nums.length-countOfDupes;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));

    }
}
