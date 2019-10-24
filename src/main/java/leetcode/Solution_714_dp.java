package leetcode;

import java.util.Arrays;

/**
 * @program: algorithms
 * @description:
 * @author: wxq
 * @date 2019-05-23 19:29
 **/
public class Solution_714_dp {

    // 耗时
    public static int maxProfitError(int[] prices, int fee) {
        int[] dp = new int[prices.length];
        Arrays.fill(dp, 0);

        for (int i = 1; i < prices.length; i++) {
            dp[i] = dp[i-1];
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j] + prices[i] - prices[j] - fee);
            }
        }
        for (int i : dp) {
            System.out.print(i + " ");
        }
        System.out.println();

        return dp[prices.length-1];
    }

    public static int maxProfit(int[] prices, int fee) {
        if (prices.length < 2){
            return 0;
        }
        int[] hold = new int[prices.length];
        int[] unhold = new int[prices.length];
        Arrays.fill(hold, 0);
        Arrays.fill(unhold, 0);
        hold[0] -= prices[0];
        for (int i = 1; i < prices.length; i++) {
            hold[i] = Math.max(hold[i-1], unhold[i-1] - prices[i]);
            unhold[i] = Math.max(unhold[i-1], hold[i-1] + prices[i] -fee);
        }

        for (int i : hold) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i : unhold) {
            System.out.print(i + " ");
        }
        System.out.println();

        return unhold[prices.length-1];

    }

    public static void main(String[] args) {
        int[] prices = new int[]{1, 3, 2, 8, 4, 9};
        int fee = 2;

        System.out.println(maxProfit(prices, fee));
    }
}
