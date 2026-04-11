package main.java.com.binarytrees;

import java.util.LinkedList;
import java.util.Queue;

public class Y_SerializeDeserialize {

    public static String serialize(TreeNode root) {

        StringBuilder ans = new StringBuilder();
        if(root==null)
            return ans.toString();
        Queue<TreeNode> nodesQ = new LinkedList<>();
        nodesQ.offer(root);
        while (!nodesQ.isEmpty())
        {
            int size = nodesQ.size();
            for(int count=0;count<size;count++)
            {
                TreeNode node = nodesQ.poll();
                if(node!=null) {
                    ans.append(node.val);
                    ans.append(",");
                    nodesQ.offer(node.left);
                    nodesQ.offer(node.right);
                }
                else
                {
                    ans.append("null");
                    ans.append(",");
                }
            }
        }
        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String [] values = data.split(",");
        if(values.length==0)
            return null;
        TreeNode root = new TreeNode();
        root.val = Integer.parseInt(values[0]);
        int count =1;
        Queue<TreeNode> nodesQ = new LinkedList<>();
        nodesQ.offer(root);
        while(count<values.length)
        {
            for(int i =0;i<nodesQ.size() && count<values.length;i++) {
                TreeNode node = nodesQ.poll();
                if (!values[count].equals("null")) {
                    node.left = new TreeNode();
                    node.left.val = Integer.parseInt(values[count]);
                    nodesQ.offer(node.left);
                }
                count++;
                if (!values[count].equals("null")) {
                    node.right = new TreeNode();
                    node.right.val = Integer.parseInt(values[count]);
                    nodesQ.offer(node.right);
                }
                count++;
            }
        }
        return root;

    }
    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(9);

        // Print the result
        System.out.println(serialize(deserialize(serialize(root))));
        System.out.println(serialize(root));

    }
}
