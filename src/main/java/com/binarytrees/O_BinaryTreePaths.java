package main.java.com.binarytrees;

import java.util.LinkedList;
import java.util.List;

public class O_BinaryTreePaths {

    public static List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> paths = new LinkedList<>();
        StringBuilder s = new StringBuilder();
        derivePathOfLeafNodes(root,paths,s);
        return paths;

    }

    public static void derivePathOfLeafNodes(TreeNode root, LinkedList<String> paths, StringBuilder leafPath)
    {
        if(root==null)
        {
            return;
        }
        if (root.left==null&&root.right==null)
        {
            if(leafPath.length()>0 && !String.valueOf(leafPath.charAt(leafPath.length()-1)).equals(">"))
            {
                leafPath.append("->");
            }
            leafPath.append(root.val);
            paths.add(String.valueOf(leafPath));
            if(leafPath.toString().contains("->"))
                leafPath.delete(leafPath.lastIndexOf("->"),leafPath.length());
            return;
        }
        if(leafPath.length()>0 &&!String.valueOf(leafPath.charAt(leafPath.length()-1)).equals(">"))
        {
            leafPath.append("->");
        }
        leafPath.append(root.val).append("->");
        derivePathOfLeafNodes(root.left,paths,leafPath);
        derivePathOfLeafNodes(root.right,paths,leafPath);
        if(leafPath.toString().contains("->")) {
            leafPath.delete(leafPath.lastIndexOf("->"), leafPath.length());
        }
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(8);
//        root.right = new TreeNode(3);
//        root.right.right = new TreeNode(5);


        // Get the Vertical traversal
        List<String> topView = binaryTreePaths(root);

        // Print the result
        System.out.print(topView);

    }
}
