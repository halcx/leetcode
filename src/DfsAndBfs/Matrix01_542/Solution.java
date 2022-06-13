package DfsAndBfs.Matrix01_542;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个由 0 和 1 组成的矩阵 mat，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
 *
 * 两个相邻元素间的距离为 1 。
 */
public class Solution {
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new LinkedList<>();
        int r = mat.length;
        int c = mat[0].length;
        boolean[][] seen = new boolean[r][c];
        int[][] ans = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(mat[i][j]==0){
                    queue.offer(new int[]{i,j});
                    seen[i][j] = true;
                }
            }
        }
        //广度优先搜索
        while (!queue.isEmpty()){
            int[] cell = queue.poll();
            for (int[] dir : dirs) {
                int i = cell[0]+dir[0];
                int j  =cell[1]+dir[1];
                if(i>=0 && i<r && j>=0 && j<c && !seen[i][j]){
                    ans[i][j] = ans[cell[0]][cell[1]] +1;
                    queue.offer(new int[]{i,j});
                    seen[i][j] = true;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] ints = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] ints1 = new Solution().updateMatrix(ints);
        for (int[] ints2 : ints1) {
            for (int i : ints2) {
                System.out.println(i);
            }
        }
    }
}
