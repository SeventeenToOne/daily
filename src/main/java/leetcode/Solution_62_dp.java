package leetcode;

/**
 * @program: algorithms
 * @description:
 *
 * @author: wxq
 * @date 2019-04-03 15:28
 **/
public class Solution_62_dp {

    public static int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int[][] counts = new int[m][n];

        for (int i = 0; i < n; i++) {
            counts[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            counts[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                counts[i][j] = counts[i-1][j] + counts[i][j-1];
            }
        }
        return counts[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(7, 3));
    }
}
