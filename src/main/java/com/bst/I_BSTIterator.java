package main.java.com.bst;

import main.java.com.binarytrees.TreeNode;

import java.util.Stack;

public class I_BSTIterator {

    /**
     * <a href="https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/description/">1008. Construct Binary Search Tree from Preorder Traversal</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=D2jMcmxU4bs&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=51">Video link</a>
     */

    private Stack<TreeNode> s = new Stack<>();

    public I_BSTIterator(TreeNode root) {
        pushAll(root);
    }

    public int next() {
        TreeNode temp = s.pop();
        pushAll(temp.right);
        return temp.val;
    }

    public boolean hasNext() {
       return !s.isEmpty();
    }

    private void pushAll(TreeNode root)
    {
        for(;root!=null;s.push(root),root=root.left);
    }
}
