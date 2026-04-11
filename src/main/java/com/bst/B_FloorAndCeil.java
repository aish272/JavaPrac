package main.java.com.bst;

import main.java.com.binarytrees.B_InorderTraversal;
import main.java.com.binarytrees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class B_FloorAndCeil {

    public static int returnFloor(TreeNode root, int num) {
        int floor = -1;
        while (root != null) {
            int value = root.val;
            if (value == num)
                return value;
            if (value < num) {
                floor = value;
                root = root.right;
            }
            else {
                root = root.left;
            }
        }
        return floor;
    }

    public static int returnCeil(TreeNode root, int num) {
        int ceil = Integer.MAX_VALUE;
        while (root != null) {
            int value = root.val;
            if (value == num)
                return value;
            if (value > num) {
                ceil = value;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return ceil;
    }

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> ans = new LinkedList<>();
        for (int num : queries) {
            List<Integer> cf = new LinkedList<>();
            cf.add(returnFloor(root, num));
            int ceil = returnCeil(root, num);
            if (ceil == Integer.MAX_VALUE)
                cf.add(-1);
            else
                cf.add(ceil);
            ans.add(cf);
        }
        return ans;
    }

    public static List<List<Integer>> closestNodes1(TreeNode root, List<Integer> queries) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sortedList = B_InorderTraversal.inorderTraversal(root);
        for (int num : queries) {
            ans.add(findFloorCeilOnePass(sortedList, num));
        }
        return ans;

    }

    public static List<Integer> findFloorCeilOnePass(List<Integer> sortedList, int num) {
        List<Integer> floorCeil = new LinkedList<>();
        int floor = -1;
        int ceil = -1;
        int start = 0;
        int end = sortedList.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int midval = sortedList.get(mid);
            if (midval == num) {
                floor = ceil = midval;
                break;
            } else if (midval > num) {
                ceil = midval;
                end = mid - 1;
            } else if (midval < num) {
                floor = midval;
                start = mid + 1;
            }
        }
        floorCeil.add(floor);
        floorCeil.add(ceil);
        return floorCeil;
    }
    public List<Integer> findFloorCeil(List<Integer> sortedList, int num) {
        List<Integer> floorCeil = new LinkedList<>();
        int floor = -1;
        int ceil = -1;
        int start = 0;
        int end = sortedList.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int midval = sortedList.get(mid);
            if (midval == num) {
                floor = midval;
                break;
            } else if (midval > num) {
                end = mid - 1;
            } else if (midval < num) {
                floor = midval;
                start = mid + 1;
            }
        }
        floorCeil.add(floor);
        start = 0;
        end = sortedList.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int midval = sortedList.get(mid);
            if (midval == num) {
                ceil = midval;
                break;
            } else if (num < midval) {
                ceil = midval;
                end = mid - 1;
            } else if (midval < num) {
                start = mid + 1;
            }
        }
        floorCeil.add(ceil);
        return floorCeil;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.left.right.right = new TreeNode(9);
        root.right = new TreeNode(13);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(14);
        System.out.println(returnCeil(root, 8));
    }
}
