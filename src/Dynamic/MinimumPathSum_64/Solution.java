package Dynamic.MinimumPathSum_64;

//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
//说明：每次只能向下或者向右移动一步。

/**
 * 状态定义：
 * dp[i][j] 到（i,j）处的最小路径和
 *
 * 状态初始化：
 * dp[0][0] = grid[0][0]
 * dp[i][0] = 纵向路径和
 * dp[0][j] = 横向路径和
 *
 * 状态转移：
 * dp[i][j] = min(dp[i-1][j],dp[i][j-1])+grid[i][j]
 *
 * 最终结果:
 * dp[n][n]
 *
 *
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[][] dp = new int[r][c];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < r; i++) {
            dp[i][0] = dp[i-1][0]+grid[i][0];
        }
        for (int i = 1; i < c; i++) {
            dp[0][i] = dp[0][i-1]+grid[0][i];
        }

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[r-1][c-1];
    }

    public static void main(String[] args) {
        int[][] ints = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int sum = new Solution().minPathSum(ints);
        System.out.println(sum);
    }
}
