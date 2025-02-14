package main.java.com.arrays1;

import java.util.*;

public class Y_4Sum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        long sum= 0L;
        Set<List<Integer>> ans = new HashSet<>();
        for (int firstEle = 0; firstEle <= length - 4; firstEle++) {
            for (int secEle = firstEle + 1; secEle <= length - 3; secEle++) {
                int thirdEle = secEle + 1;
                int fourthEle = length - 1;

                while (thirdEle < fourthEle) {
                    sum = (long)nums[firstEle] + nums[secEle] + nums[thirdEle] + nums[fourthEle];
                    if (sum < target) {
                        thirdEle++;
                    } else if (sum > target) {
                        fourthEle--;
                    } else {
                        List<Integer> temp = List.of(nums[firstEle], nums[secEle], nums[thirdEle], nums[fourthEle]);
                        ans.add(temp);
                        thirdEle++;
                        fourthEle--;

                    }
                }

            }
        }
        return new ArrayList<>(ans);
    }
    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1000000000,1000000000,1000000000,1000000000},-294967296));
    }
}
