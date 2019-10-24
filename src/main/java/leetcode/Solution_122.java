package leetcode;

public class Solution_122 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i <n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }

        return dp[prices.length - 1][0];


    }

    public static void main(String[] args) {
        Solution_122 solution = new Solution_122();
        int[] prices = new int[]{1, 7, 5, 3, 6, 4};
        int[] prices1 = new int[]{1, 2, 3, 4};
        System.out.println(solution.maxProfit(prices));

    }
}
