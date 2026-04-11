package main.java.com.graph;

public class E_FloodFill {

    /**
     * <a href="https://leetcode.com/problems/flood-fill/description/">733. Flood Fill</a>
     * <br/>
     * <a href="https://www.youtube.com/watch?v=C-2_uSRli8o&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=9">Video solution link</a>
     */
    private static int[][] directions = {
            { -1, 0 }, // Up
            { 1, 0 }, // Down
            { 0, -1 }, // Left
            { 0, 1 } // Right
    };
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int[][] ans = image; //copying image to ans because we shouldn't make changes to input val acc. to Striver baba.
        int initialColor = image[sr][sc];
        dfsInMatrix(image,ans,sr,sc,color,initialColor);
        return ans;
    }

    private void dfsInMatrix(int[][] image,int[][] ans, int sr, int sc, int color, int initialColor)
    {
        ans[sr][sc]=color;
        for(int count = 0; count <4; count++)
        {
            int newR = directions[count][0]+sr;
            int newC = directions[count][1]+sc;
            if(newR<image.length&&newR>=0 && newC>=0&&newC<image[0].length
                 &&image[newR][newC]!=color&&image[newR][newC]==initialColor)
            {
                dfsInMatrix(image,ans,newR,newC,color,initialColor);
            }
        }
    }
}
