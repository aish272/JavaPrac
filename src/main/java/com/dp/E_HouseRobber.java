package main.java.com.dp;

public class E_HouseRobber {

    public static int rob(int[] nums) {
        int[] dp = new int[nums.length];
        for(int i =0;i<nums.length;i++)
        {
            dp[i] = -1;
        }
        return returnMaxSum(nums.length-1,nums, dp);
    }

    public static int returnMaxSum(int index, int[] nums, int[] dp)
    {
        if(index==0)
            return nums[0];
        else if(index<0)
            return 0;
        if(dp[index]!=-1)
            return dp[index];
        int pick = nums[index]+returnMaxSum(index-2,nums, dp);
        int notPick = 0 + returnMaxSum(index - 1, nums, dp);
        return dp[index]=Math.max(pick,notPick);
    }

    public static int robTabulation(int[] nums)
    {
        int grandF = nums[0];
        if(nums.length>1) {
            int father = Math.max(nums[0], nums[1]);
            for (int index = 2; index < nums.length; index++) {
                int pick = nums[index] + grandF;
                int notPick = 0 + father;
                grandF = father;
                father = Math.max(pick, notPick);
            }
            return father;
        }
        else return grandF;
    }
    public static void main(String[] arg) {
        int[] dpArr = new int[]{2,7,9,3,1};
        System.out.println(rob(dpArr));
    }
}
