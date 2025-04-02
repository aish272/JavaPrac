package main.java.com.binarytrees;

public class G_DiameterOFBinaryTree {

    public static int diameterOfBinaryTree(TreeNode root) {
        int[] arr = new int[1];
        return getDiameter(root,arr);
    }

    public static int getDiameter(TreeNode root,int[] max)
    {
        if(root==null)
            return 0;
        int lh = getHeight(root.left);
        int rh = getHeight(root.right);
        max[0] = Math.max(max[0],lh+rh);
        getDiameter(root.left,max);
        getDiameter(root.right,max);
        return max[0];

    }

    public static int getHeight(TreeNode root)
    {
        if(root==null)
            return 0;
        int lh = getHeight(root.left);
        int rh = getHeight(root.right);
        return Math.max(lh,rh)+1;
    }

    public static int diameterOfBinaryTreeOptimized(TreeNode root) {
        int[] arr = new int[1];
        getHeightAndCalculateDiameter(root,arr);
        return arr[0];
    }

    public static int getHeightAndCalculateDiameter(TreeNode root,int[] arr)
    {
        if(root==null)
            return 0;
        int lh = getHeightAndCalculateDiameter(root.left,arr);
        int rh = getHeightAndCalculateDiameter(root.right,arr);
        arr[0] = Math.max(arr[0],lh+rh);
        return Math.max(lh,rh)+1;
    }



    public static void main(String[] args)
    {

        TreeNode root = new TreeNode(1);
         root.left = new TreeNode(1);
         root.left.right = new TreeNode(10);
        System.out.println(diameterOfBinaryTree(root));
    }
}
