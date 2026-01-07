package main.java.com.binarytrees2;

import main.java.com.binarytrees.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class F_LeafSimilarTrees {


    /**
     * <a href="https://leetcode.com/problems/leaf-similar-trees/">872. Leaf-Similar Trees</a>
     **/
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> seq = new LinkedList<>();
        List<Integer> seq1 = new LinkedList<>();
        returnLeafSequence(root1, seq);
        returnLeafSequence(root2, seq1);
        return seq.equals(seq1);

    }

    public void returnLeafSequence(TreeNode root, List<Integer> seq) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            seq.add(root.val);
            return;
        }
        returnLeafSequence(root.left, seq);
        returnLeafSequence(root.right, seq);

    }
}
