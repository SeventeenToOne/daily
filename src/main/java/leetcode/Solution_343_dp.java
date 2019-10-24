package leetcode;

import java.util.Arrays;

/**
 * @program: algorithms
 * @description:
 * @author: wxq
 * @date 2019-05-20 21:34
 **/
public class Solution_343_dp {


    public static int integerBreak(int n) {
        if (n <= 3) return n-1;
        int[] dp = new int[n+1];
        Arrays.fill(dp, 0);
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i < n+1; i++) {
            for (int j = 1; j <= i/2; j++) {
                dp[i] = Math.max(dp[i], dp[j] * dp[i-j]);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }
}
