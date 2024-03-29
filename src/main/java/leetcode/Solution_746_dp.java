package leetcode;

import java.util.Arrays;

/**
 * @program: algorithms
 * @description:
 * 数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 *
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 *
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 *
 * 示例 1:
 *
 * 输入: cost = [10, 15, 20]
 * 输出: 15
 * 解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
 *  示例 2:
 *
 * 输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出: 6
 * 解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
 * @author: wxq
 * @date 2019-03-08 20:37
 **/
public class Solution_746_dp {
    public static int minCostClimbingStairs(int[] cost) {
        int[] curCosts = new int[cost.length];
        Arrays.fill(curCosts, 0);
        if(cost.length == 0){
            return 0;
        }
        if (cost.length == 1){
            return cost[0];
        }
        if(cost.length == 2){
            return cost[1] > cost[0]? cost[0]: cost[1];
        }
        curCosts[0] = cost[0];
        curCosts[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            if ((cost[i] + curCosts[i-1]) > (cost[i] + curCosts[i-2])) {
                curCosts[i] = cost[i] + curCosts[i-2];
            }else {
                curCosts[i] = cost[i] + curCosts[i-1];
            }
        }
        return curCosts[cost.length-1] > curCosts[cost.length-2] ? curCosts[cost.length-2]: curCosts[cost.length-1];
    }

    public static void main(String[] args) {
        int[] cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(cost));
    }
}
