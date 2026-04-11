package main.java.com.binarytrees;

import java.util.HashMap;
import java.util.Map;

public class X_ConstructTreeWithInorderAndPostorder {
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> hashingMap = new HashMap<>();
        for (int count = 0; count < inorder.length; count++) {
            hashingMap.put(inorder[count],count);
        }
        return returnRootNode(postorder, 0,postorder.length-1,inorder,0,inorder.length-1,hashingMap );
    }

    public static TreeNode returnRootNode(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd, Map<Integer,Integer> hashingMap) {
        if(postStart > postEnd || inStart>inEnd)
        {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int rootIndex = hashingMap.get(root.val);
        int numsOnLeftOfInorder = rootIndex-inStart;
        root.left = returnRootNode(postorder, postStart, postStart + numsOnLeftOfInorder-1,
                inorder, inStart, rootIndex - 1, hashingMap);
        root.right = returnRootNode(postorder, postStart + numsOnLeftOfInorder, postEnd-1,
                inorder, rootIndex + 1, inEnd, hashingMap);
        return root;


    }

    public static void main(String[] args) {
        buildTree(new int[]{9,3,15,20,7},new int[]{3,9,20,15,7});
    }


}
