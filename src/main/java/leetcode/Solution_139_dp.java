package leetcode;

import java.util.List;

/**
 * @program: algorithms
 * @description:
 * @author: wxq
 * @date 2019-05-31 20:31
 **/
public class Solution_139_dp {
    boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];

    }

    public static void main(String[] args) {
        new Solution_139_dp();
    }
}
