package main.java.com.binarytrees;

import java.util.HashMap;
import java.util.Map;

public class W_ConstructTreeWithInorderAndPreorder {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> hashingMap = new HashMap<>();
        for (int count = 0; count < inorder.length; count++) {
            hashingMap.put(inorder[count],count);
        }
        return returnRootNode(preorder, 0,preorder.length-1,inorder,0,inorder.length-1,hashingMap );
    }

    public static TreeNode returnRootNode(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer,Integer> hashingMap) {
        if(preStart>preEnd  || inStart>inEnd)
        {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndex = hashingMap.get(root.val);
        int numsOnLeftOfInorder = rootIndex-inStart;
        root.left = returnRootNode(preorder, preStart + 1, preStart + numsOnLeftOfInorder,
                inorder, inStart, rootIndex - 1, hashingMap);
        root.right = returnRootNode(preorder, preStart + numsOnLeftOfInorder + 1, preEnd,
                inorder, rootIndex + 1, inEnd, hashingMap);
        return root;


    }

    public static void main(String[] args) {
        buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
    }


}
