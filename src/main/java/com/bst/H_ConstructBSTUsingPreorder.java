package main.java.com.bst;

import main.java.com.binarytrees.TreeNode;

public class H_ConstructBSTUsingPreorder {

    /**
     * <a href="https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/description/">1008. Construct Binary Search Tree from Preorder Traversal</a>
     */
    public static TreeNode bstFromPreorder(int[] preorder) {
        return returnBST(preorder,0, preorder.length-1);
    }

    public static TreeNode returnBST(int[] preorder, int start, int end)
    {
        if(start>end)
            return null;
        TreeNode root = new TreeNode(preorder[start]);
        int numOnLeftNode =start+1;
        while(numOnLeftNode<preorder.length&&preorder[start]>preorder[numOnLeftNode])
        {
            numOnLeftNode++;
        }
        numOnLeftNode = numOnLeftNode-start-1;
        root.left = returnBST(preorder,start+1,start+numOnLeftNode);
        root.right = returnBST(preorder,start+numOnLeftNode+1,end);
        return root;

    }

    public static void main(String[] args)
    {
        System.out.println(bstFromPreorder(new int[]{8,5,1,7,10,12}));
    }
}
