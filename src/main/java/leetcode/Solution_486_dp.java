package leetcode;

/**
 * @program: algorithms
 * @description:
 * @author: wxq
 * @date 2019-05-27 21:12
 **/
public class Solution_486_dp {
    public static boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        long[][] dp = new long[n][n];
        long[] sum = new long[n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i-1] + nums[i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; i+j < n; j++){
                dp[j][j+i] = Math.max(sum[j+i] - sum[j] + nums[j] - dp[j+1][j+i],
                                    sum[j+i] - sum[j] + nums[j] - dp[j][j+i-1]);
            }
        }
        for (int i = 0; i < sum.length; i++) {
            System.out.print(sum[i] + " ");

        }
        System.out.println();
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }


        return 2 * dp[0][n-1] >= sum[n-1];

    }

    public static void main(String[] args) {

        int[] nums = new int[]{877854,7113184,3270279,2243110,1902970,9268285,8784788,3837608,6582224,8751349,6928223,3108757,1120749,1872910,7762600,4220578,4692740,3409910,6807125,6808582};

        System.out.println(PredictTheWinner(nums));
    }
}
