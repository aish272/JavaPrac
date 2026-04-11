package main.java.com.binarytrees2;

import main.java.com.binarytrees.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class H_FindDupeSubtree {

    /**
     * <a href="https://leetcode.com/problems/find-duplicate-subtrees/">652. Find Duplicate Subtrees</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=m0dG99f5ct4&list=PLpIkg8OmuX-K23LhcamOcDlTBisiNJy5E&index=21">Video solution link</a>
     */
    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> ans = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        addSubtree(root);
        return ans;
    }

    public String addSubtree(TreeNode root) {
        if (root == null) {
            return "N";
        }

        String rootString = root.val + "," + addSubtree(root.left) + "," +
                addSubtree(root.right);
        int count = map.getOrDefault(rootString, 0);
        if (count == 1) {
            ans.add(root);
        }
        map.put(rootString, count + 1);

        return rootString;

    }
}
