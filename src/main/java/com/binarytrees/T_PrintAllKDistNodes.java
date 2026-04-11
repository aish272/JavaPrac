package main.java.com.binarytrees;

import java.util.*;

public class T_PrintAllKDistNodes {

    private static void addParentInfo(TreeNode root, Map<TreeNode,TreeNode> parentTrack)
    {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty())
        {
            TreeNode current = q.poll();
            if(current.left!=null)
            {
                parentTrack.put(current.left,current);
                q.offer(current.left);
            }
            if(current.right!=null)
            {
                parentTrack.put(current.right,current);
                q.offer(current.right);
            }
        }
    }

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        Map<TreeNode,TreeNode> parentTrack =new HashMap<>();
        addParentInfo(root,parentTrack);
        Queue<TreeNode> visited = new LinkedList<>();
        Queue<TreeNode> traversal = new LinkedList<>();
        traversal.offer(target);
        visited.offer(target);
        int dist=0;
        while (dist<k)
        {

                dist++;
                int size = traversal.size();
                for(int counter=0;counter<size;counter++)
                {
                    TreeNode current = traversal.poll();
                    if(current.left!=null&& !visited.contains(current.left))
                    {
                        traversal.offer(current.left);
                        visited.offer(current.left);
                    }
                    if(current.right!=null&& !visited.contains(current.right))
                    {
                        traversal.offer(current.right);
                        visited.offer(current.right);
                    }
                    if(parentTrack.get(current)!=null&& !visited.contains(parentTrack.get(current)))
                    {
                        traversal.offer(parentTrack.get(current));
                        visited.offer(parentTrack.get(current));
                    }
                }

            }
        List<Integer> ans = new ArrayList<>();
        for(TreeNode n:traversal)
        {
            ans.add(n.val);
        }
        return ans;
    }
    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(5);


        // Get the Vertical traversal
        List<Integer> topView = distanceK(root,root.right,1);

        // Print the result
        System.out.print(topView);

    }
}
