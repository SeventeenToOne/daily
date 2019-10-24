package leetcode;

public class Solution_115 {
    public int numDistinct(String s, String t) {
        if(s == null || s.length() == 0){
            return 0;
        }
        if (t == null || t.length() == 0){
            return 0;
        }

        int slen = s.length();
        int tlen = t.length();
        int[][] dp = new int[tlen + 1][slen + 1];

        for (int i = 0; i <= slen; i++) {
            dp[0][i] = 1;
        }

        for(int i = 1; i<=tlen; i++){
            dp[i][0] = 0;
            for(int j = 1; j <= slen; j++){
                if(s.charAt(j-1) == t.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                }else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        return dp[tlen][slen];

    }

    public static void main(String[] args) {
        Solution_115 solution = new Solution_115();
        System.out.println(solution.numDistinct("babgbag", "bag"));
    }
}

// 115. 不同的子序列
/*
*
输入: S = "babgbag", T = "bag"
输出: 5
解释:
* */