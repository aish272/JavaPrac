package main.java.com.binarytrees2;

import main.java.com.binarytrees.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class M_DeleteNodesAndReturnForest {

    /**
     * <a href="https://leetcode.com/problems/delete-nodes-and-return-forest/">1110. Delete Nodes And Return Forest</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=z-pX53sYwWI&list=PLpIkg8OmuX-K23LhcamOcDlTBisiNJy5E&index=7">Video solution link</a>
     */
    Set<Integer> deleteThemAll = new HashSet<>();
    List<TreeNode> ans = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        for (int i : to_delete) {
            deleteThemAll.add(i);
        }
        returnForest(root);
        if (!deleteThemAll.contains(root.val)) {
            ans.add(root);
        }
        return ans;

    }

    public TreeNode returnForest(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null && deleteThemAll.contains(root.val)) {

            if (deleteThemAll.contains(root.val)) {
                return null;
            } else {
                return root;
            }
        }
        root.left = returnForest(root.left);
        root.right = returnForest(root.right);
        if (deleteThemAll.contains(root.val)) {
            if (root.left != null)
                ans.add(root.left);

            if (root.right != null)
                ans.add(root.right);
            root = null;
        }
        return root;

    }
}
