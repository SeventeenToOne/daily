package leetcode;

/**
 * @program: algorithms
 * @description:
 * @author: wxq
 * @date 2019-05-27 19:39
 **/
public class Solution_516_dp {
    int[][] dp;
    public  int longestPalindromeSubseq(String s) {
        dp = new int[s.length()][s.length()];

        for (int i = dp.length -1 ; i >= 0 ; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < dp[i].length; j++) {
                if (s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[0][s.length()-1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution_516_dp().longestPalindromeSubseq("cbbd"));
    }
}
