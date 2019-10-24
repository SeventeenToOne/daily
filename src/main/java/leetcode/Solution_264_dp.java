package leetcode;

/**
 * @program: algorithms
 * @description:
 * @author: wxq
 * @date 2019-05-27 20:18
 **/
public class Solution_264_dp {
    public static int nthUglyNumber(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        int index3 = 1, index2 = 1, index5 = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[index3]*3, Math.min(dp[index2]*2, dp[index5]*5));
            if (dp[i] == dp[index2] * 2) index2++;
            if (dp[i] == dp[index3] * 3) index3++;
            if (dp[i] == dp[index5] * 5) index5++;

        }

        return dp[n];

    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }
}
