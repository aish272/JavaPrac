package main.java.com.dp;

public class F_HouseRobber2 {

    public static int rob(int[] nums) {
        int[] withFirstEle = new int[nums.length-1];
        int[] withLastElement = new int[nums.length-1];
        if(nums.length>1) {
            for (int counter = 0; counter < nums.length; counter++) {
                if (counter != 0)
                    withLastElement[counter - 1] = nums[counter];
                if (counter != nums.length - 1)
                    withFirstEle[counter] = nums[counter];

            }
            return Math.max(robTabulation(withFirstEle), robTabulation(withLastElement));
        }
        else
            return nums[0];
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
