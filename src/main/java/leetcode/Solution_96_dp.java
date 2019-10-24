package leetcode;

import java.util.Arrays;

/**
 * @program: algorithms
 * @description:
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * @author: wxq
 * @date 2019-03-14 21:45
 **/
public class Solution_96_dp {
    public static int numTrees(int n) {
        int[] dp = new int[n+1];
//        Arrays.fill(dp, 0);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            if(i==1 || i==2) {
                dp[i] = i;
            }else {
                dp[i] = 0;
                for (int j = 1; j <= n; j++) {
                    if(j>1 && i>j){
                        dp[i] += dp[j-1] * dp[i-j];
                    }
                    if(j == 1 || j == n){
                        dp[i] += dp[i-1];
                    }
                }
            }

        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(4));
        System.out.println(numTrees(2));
        System.out.println(numTrees(3));
    }
}
