package leetcode;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import javax.swing.plaf.metal.MetalTheme;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @program: algorithms
 * @description:
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 *
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * @author: wxq
 * @date 2019-05-24 19:35
 **/
public class Solution_309_dp {
    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        int[] hold = new int[prices.length];
        int[] unhold = new int[prices.length];
        Arrays.fill(hold, 0);
        Arrays.fill(unhold, 0);
        hold[0] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            hold[i] = Math.max(hold[i-1], unhold[Math.max(0, i-2)] - prices[i]);
            unhold[i] = Math.max(unhold[i-1], hold[i-1] + prices[i]);
        }

        return unhold[prices.length-1];


    }

    public static void main(String[] args) {
        int[] prices = new int[]{};
        System.out.println(maxProfit(prices));
    }
}
