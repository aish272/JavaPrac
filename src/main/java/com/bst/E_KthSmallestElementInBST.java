package main.java.com.bst;

import main.java.com.binarytrees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class E_KthSmallestElementInBST {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> sortedList = returnSortedListUsingInorderTraversal(root,new ArrayList<>());
        return sortedList.get(k-1);

    }

    public List<Integer> returnSortedListUsingInorderTraversal(TreeNode root, List<Integer>sortedList)
    {
        if(root==null)
            return sortedList;
        returnSortedListUsingInorderTraversal(root.left,sortedList);
        sortedList.add(root.val);
        returnSortedListUsingInorderTraversal(root.right,sortedList);
        return sortedList;

    }
}
