package leetcode;

public class Solution_121 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }

        return dp[n-1][0];

    }

    public static void main(String[] args) {
        Solution_121 solution = new Solution_121();
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(solution.maxProfit(prices));

    }
}
