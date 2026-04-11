package main.java.com.greedyAlgo;

public class D_JumpGame1 {

    /**
     * <a href="https://leetcode.com/problems/jump-game/">55. Jump Game</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=tZAa_jJ3SwQ">Video solution link</a>
     * */
    public static boolean canJump(int[] nums) {

        if (nums.length == 1) {
            return true;
        }

        int index = 0;
        int reach = 0;

        while (index < nums.length) {
            int newReach = index + nums[index];
            if ((reach == index && nums[index] == 0) && index < nums.length - 1) {
                return false;
            }
            if (newReach > reach) {
                reach = newReach;

            }
            if (reach >= nums.length - 1) {
                return true;
            }
            index++;
        }
        return false;

    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));

    }
}
