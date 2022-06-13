package DfsAndBfs.MaxAreaofIsland_695;

/**
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 *
 * 岛屿是由一些相邻的1(代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设grid 的四个边缘都被 0（代表水）包围着。
 *
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 *
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 */
public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ans = Math.max(ans,dfs(grid,i,j));
            }
        }
        return ans;
    }

    public int dfs(int[][] grid,int cur_i,int cur_j){
        if(cur_i<0 || cur_i== grid.length || cur_j<0 && cur_j ==grid[0].length || grid[cur_i][cur_j] == 0){
            return 0;
        }
        //把遍历过的置为0
        grid[cur_i][cur_j] = 0;
        int[][] index = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        //这个ans指的是这一个没有访问过的权重
        int ans = 1;
        for (int[] ints : index) {
            int ni = cur_i+ints[0];
            int nj = cur_j+ints[1];
            ans+=dfs(grid,ni,nj);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] input = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        int i = new Solution().maxAreaOfIsland(input);
        System.out.println(i);
    }

}
