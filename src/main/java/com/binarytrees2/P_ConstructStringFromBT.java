package main.java.com.binarytrees2;

import main.java.com.binarytrees.TreeNode;

public class P_ConstructStringFromBT {

    /**
     * <a href="https://leetcode.com/problems/construct-string-from-binary-tree/description/">606. Construct String from Binary Tree</a>
     **/
    public String tree2str(TreeNode root) {
        return returnPattern(root, new StringBuilder()).deleteCharAt(0).toString();
    }

    public StringBuilder returnPattern(TreeNode root, StringBuilder st) {
        if (root.left == null && root.right == null) {
            st.append("(").append(root.val);
            return st;
        }
        st.append("(").append(root.val);
        if (root.left == null)
            st.append("(");

        else
            returnPattern(root.left, st);
        st.append(")");
        if (root.right != null) {
            returnPattern(root.right, st);
            st.append(")");
        }
        return st;

    }
}
