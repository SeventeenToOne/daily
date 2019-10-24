package leetcode;

import java.util.Arrays;

/**
 * @program: algorithms
 * @description:
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * @author: wxq
 * @date 2019-03-14 21:19
 **/
public class Solution_64_dp {

    public static int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int[][] curVaule = new int[m][n];
        curVaule[0][0] = grid[0][0];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i-1 < 0 && j-1 >= 0){
                    curVaule[i][j] = grid[i][j] + curVaule[i][j-1];
                }

                if(j-1 < 0 && i-1 >= 0){
                    curVaule[i][j] = grid[i][j] + curVaule[i-1][j];
                }

                if(j-1 >= 0 && i-1 >= 0){
                    curVaule[i][j] = Math.min(grid[i][j] + curVaule[i][j-1], grid[i][j] + curVaule[i-1][j]);
                }
            }
        }
        return curVaule[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,10,1}, {1,3,1}, {4,2,1}};
        System.out.println(minPathSum(grid));
    }
}
