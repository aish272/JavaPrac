package main.java.com.binarytrees;

import java.util.LinkedList;
import java.util.List;

public class ZB_SumRootLeafNumbers {

    /**
     * <a href="https://leetcode.com/problems/sum-root-to-leaf-numbers">129. Sum Root to Leaf Numbers</a>
     */

    public static int sumNumbers(TreeNode root) {



        List<String> pathList = new LinkedList<>();
        returnRootToLeafPath(root, new StringBuilder(), pathList);
        int ans = 0;
        for(String s: pathList)
        {
            ans += Integer.parseInt(s);
        }
        return ans;



    }

    public static void returnRootToLeafPath(TreeNode root, StringBuilder s, List<String> pathList)
    {
        if(root.left==null && root.right==null)
        {
            s.append(root.val);
            pathList.add(String.valueOf(s));
            return;
        }

        s.append(root.val);
        returnRootToLeafPath(root.left, s, pathList);
        if(s.length()>0)
            s.deleteCharAt(s.length()-1);
        returnRootToLeafPath(root.right, s, pathList);
        if(s.length()>0)
            s.deleteCharAt(s.length()-1);

    }

    public static void main(String[] args)
    {


        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode root = new TreeNode(left,right,1);
        System.out.println(sumNumbers(root));
    }
}
