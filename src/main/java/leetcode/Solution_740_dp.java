package leetcode;

import java.util.Arrays;

/**
 * @program: algorithms
 * @description:
 * @author: wxq
 * @date 2019-05-23 20:26
 **/
public class Solution_740_dp {
    public static int deleteAndEarn(int[] nums) {
        int[] trans = new int[10001];
        Arrays.fill(trans, 0);

        for (int num : nums) {
            trans[num] += num;
        }

        int[] dp = new int[10001];
        dp[0] = 0;
        dp[1] = trans[1];
        for (int i = 2; i < trans.length; i++) {
            dp[i] = Math.max(dp[i-2] + trans[i], dp[i-1]);
        }

        return dp[10000];

    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 3, 3, 3, 4, 4, 4, 3, 2, 3,1,5};
        System.out.println(deleteAndEarn(nums));
    }
}
