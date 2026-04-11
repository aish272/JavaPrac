package main.java.com.bst;

import main.java.com.binarytrees.TreeNode;

import java.util.*;

public class P_FindModeInBST {

    /**
     * <a href="https://leetcode.com/problems/find-mode-in-binary-search-tree/description/?envType=problem-list-v2&envId=binary-search-tree">501. Find Mode in Binary Search Tree</a>
     */
    public static int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        returnMaxFreqAndReturnFreqMap(root, map);
        int maxFreq = map.values().stream().max(Comparator.naturalOrder()).get();
        List<Integer> l = new ArrayList<>();
        for (Map.Entry<Integer, Integer> ele : map.entrySet()) {
            if (ele.getValue() == maxFreq) {
                l.add(ele.getKey());
            }
        }
        System.out.println(l.toString() + "  " + maxFreq);
        int[] ans = new int[l.size()];
        for (int i = 0; i < l.size(); i++) {
            ans[i] = l.get(i);
        }
        return ans;
    }

    public static void returnMaxFreqAndReturnFreqMap(TreeNode root, Map<Integer, Integer> map) {
        if (root == null)
            return;
        int val = root.val;
        map.put(val, map.getOrDefault(val, 0) + 1);
        returnMaxFreqAndReturnFreqMap(root.left, map);
        returnMaxFreqAndReturnFreqMap(root.right, map);
        return;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        System.out.println(Arrays.toString(findMode(root)));

    }
}
