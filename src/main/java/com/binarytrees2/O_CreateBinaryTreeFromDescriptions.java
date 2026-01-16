package main.java.com.binarytrees2;

import main.java.com.binarytrees.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class O_CreateBinaryTreeFromDescriptions {

    /**
     * <a href="https://leetcode.com/problems/create-binary-tree-from-descriptions/">2196. Create Binary Tree From Descriptions</a>
     **/

    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, List<TreeNode>> valToChildParentMap = new HashMap<>();
        for (int[] des : descriptions) {
            int parent = des[0];
            int child = des[1];
            TreeNode parentN;
            if (!valToChildParentMap.containsKey(parent)) {
                parentN = new TreeNode(parent);
                List<TreeNode> temp = new ArrayList<>();
                temp.add(parentN); //add self node at index 0
                valToChildParentMap.put(parent, temp);
            } else {
                parentN = valToChildParentMap.get(parent).get(0);
            }

            TreeNode childN = null;
            if (!valToChildParentMap.containsKey(child)) {
                childN = new TreeNode(child);
                List<TreeNode> temp = new ArrayList<>();
                temp.add(childN); //add self node at index 0
                valToChildParentMap.put(child, temp);
            } else {
                childN = valToChildParentMap.get(child).get(0);
            }

            valToChildParentMap.get(child).add(parentN); //add parent node at index 1
            if (des[2] == 1) {
                parentN.left = childN;
            } else {
                parentN.right = childN;
            }

        }
        for (Map.Entry<Integer, List<TreeNode>> ele : valToChildParentMap.entrySet()) {
            if (ele.getValue().size() == 1)
                return ele.getValue().get(0);
        }
        return null;

    }
}
