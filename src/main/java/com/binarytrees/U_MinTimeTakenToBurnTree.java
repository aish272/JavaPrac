package main.java.com.binarytrees;

import java.util.*;

public class U_MinTimeTakenToBurnTree {

    //Passed 40/80 cases
    public static int amountOfTime(TreeNode root, int start) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        int targetNodeLevel = 0;
        int totalNodeLevel = 0;
        TreeNode targetNode = null;

        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            totalNodeLevel++;
            for (int counter = 0; counter < size; counter++) {

                TreeNode node = nodeQueue.poll();
                if (node.val == start) {
                    targetNodeLevel = totalNodeLevel;
                    targetNode = node;
                }

                if (node.left != null)
                    nodeQueue.offer(node.left);
                if (node.right != null)
                    nodeQueue.offer(node.right);
            }

        }
        nodeQueue.offer(targetNode);
        int nodecheck = targetNodeLevel - 1;
        while (!nodeQueue.isEmpty() && targetNode != null) {
            int size = nodeQueue.size();
            nodecheck++;
            for (int counter = 0; counter < size; counter++) {
                TreeNode node = nodeQueue.poll();
                if (node.left != null)
                    nodeQueue.offer(node.left);
                if (node.right != null)
                    nodeQueue.offer(node.right);
            }
        }

        if (nodecheck != totalNodeLevel) //last leaf node is not connected to target node
            return (targetNodeLevel - 1) + (totalNodeLevel - 1); //distance from root+distance between root and last leaf node
        else
            return (targetNodeLevel - 1) + (totalNodeLevel - targetNodeLevel);//distance from root+distance between target and last leaf node

    }

    public static TreeNode createParentChildMap(TreeNode root, Map<TreeNode,TreeNode> parentTrack, int target)
    {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        while(!nodeQueue.isEmpty())
        {
            TreeNode node = nodeQueue.poll();
            if(node.val==target)
                  return node;
            if(node.left!=null) {
                parentTrack.put(node.left, node);
                nodeQueue.offer(node.left);
            }
            if(node.right!=null) {
                parentTrack.put(node.right, node);
                nodeQueue.offer(node.right);
            }
        }
        return null;
    }

    public static int amountOfTime_StriverSol(TreeNode root, int start) {
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        Map<TreeNode,TreeNode> parentChildMap = new HashMap<>();
        TreeNode targetNodeList = createParentChildMap(root,parentChildMap,start);
        visited.add(targetNodeList);
        nodes.offer(targetNodeList);
        int timeToBurn =0;
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            for (int counter = 0; counter < size; counter++) {
                TreeNode node = nodes.poll();
                if (node.left!=null&&!visited.contains(node.left)) {
                    visited.add(node.left);
                    nodes.offer(node.left);
                }
                if (node.right!=null&&!visited.contains(node.right)) {
                    visited.add(node.right);
                    nodes.offer(node.right);
                }
                if (parentChildMap.containsKey(node)&&!visited.contains(parentChildMap.get(node))) {
                    visited.add(parentChildMap.get(node));
                    nodes.offer(parentChildMap.get(node));
                }
            }
            if(!nodes.isEmpty())
                timeToBurn++;

        }
        return timeToBurn;
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(5);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(9);
        root.left.right.right = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(6);

        // Print the result
        System.out.println(amountOfTime_StriverSol(root, 3));
    }
}
