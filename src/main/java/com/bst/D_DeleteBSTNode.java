package main.java.com.bst;

import main.java.com.binarytrees.D_LevelOrderTraversal;
import main.java.com.binarytrees.TreeNode;

public class D_DeleteBSTNode {
    public static TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
            return root;
        TreeNode[] treeNode = new TreeNode[2];
        treeNode[0] = new TreeNode();
        treeNode[1] = new TreeNode();
        if(findIfNodeExists(root, key,treeNode,null)) {
            if(root.val==key) {
                return returnModifiedLeftNode(root);
            }
            else if (treeNode[1].val>key)
            {
                treeNode[1].left = returnModifiedLeftNode(treeNode[0]);
            }
            else
            {
                treeNode[1].right = returnModifiedLeftNode(treeNode[0]);
            }
        }

        return root;

    }

    public static TreeNode returnModifiedLeftNode(TreeNode root)
    {
        if(root.left==null)
            return root.right;
        if(root.right==null)
            return root.left;
        TreeNode lastRight = findLastRight(root.left);
        lastRight.right = root.right;
        return root.left;

    }
    public static TreeNode findLastRight(TreeNode root)
    {
        if(root.right==null)
            return root;
        return findLastRight(root.right);
    }

    public static Boolean findIfNodeExists(TreeNode root, int key,TreeNode[] toBeFound,TreeNode parent)
    {
        if(root==null)
            return false;
        if(root.val==key) {
            toBeFound[0] = root;
            toBeFound[1] = parent;
            return true;
        }
        boolean left = findIfNodeExists(root.left,key,toBeFound,root);
        boolean right = findIfNodeExists(root.right,key,toBeFound,root);
        return left||right;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        System.out.println(new D_LevelOrderTraversal().levelOrder(deleteNode(root,7)));

    }
}
