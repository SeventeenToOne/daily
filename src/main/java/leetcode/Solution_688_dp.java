package leetcode;

/**
 * @program: algorithms
 * @description:
 * @author: wxq
 * @date 2019-06-03 21:27
 **/
public class Solution_688_dp {
    double[][][] dp;
    public double knightProbability(int N, int K, int r, int c) {
        // 特殊值处理
        if (K == 0) return 1;
        if (K == 1) return  findPosition(N, r, c) / 8.0;
        dp = new double[K+1][N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp[0][i][j] = 1;
            }
        }

        for (int k = 1; k < K + 1; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (j + 2 < N && i + 1 < N) {dp[k][i][j] += dp[k - 1][i + 1][j + 2];}
                    if (j + 1 < N && i + 2 < N) {dp[k][i][j] += dp[k - 1][i + 2][j + 1];}
                    if (j + 2 < N && i - 1 > -1) {dp[k][i][j] += dp[k - 1][i - 1][j + 2];}
                    if (j + 1 < N && i - 2 > -1) {dp[k][i][j] += dp[k - 1][i - 2][j + 1];}
                    if (j - 2 > -1 && i + 1 < N) {dp[k][i][j] += dp[k - 1][i + 1][j - 2];}
                    if (j - 1 > -1 && i + 2 < N) {dp[k][i][j] += dp[k - 1][i + 2][j - 1];}
                    if (j - 2 > -1 && i - 1 > -1) {dp[k][i][j] += dp[k - 1][i - 1][j - 2];}
                    if (j - 1 > -1 && i - 2 > -1) {dp[k][i][j] += dp[k - 1][i - 2][j - 1];}

                }
            }
        }

        return dp[K][r][c] / Math.pow(8, K);


    }

    int findPosition(int N, int r, int c) {
        int count = 0;
        if (c + 2 < N && r + 1 < N) {count++;}
        if (c + 1 < N && r + 2 < N) {count++;}
        if (c + 2 < N && r - 1 > -1) {count++;}
        if (c + 1 < N && r - 2 > -1) {count++;}
        if (c - 2 > -1 && r + 1 < N) {count++;}
        if (c - 1 > -1 && r + 2 < N) {count++;}
        if (c - 2 > -1 && r - 1 > -1) {count++;}
        if (c - 1 > -1 && r - 2 > -1) {count++;}
        return count;
    }


    public static void main(String[] args) {

        System.out.println(new Solution_688_dp().knightProbability(8, 30, 6, 4));
    }
}
