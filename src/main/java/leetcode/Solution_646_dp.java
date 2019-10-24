package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @program: algorithms
 * @description:
 *  boolean[] isTravel = new boolean[366]; // 当天是否旅游 1 -> 旅游的最后一天
 *         Arrays.fill(isTravel, false);
 *         for (int day : days) {
 *             isTravel[day] = true;
 *         }
 *         int[] dp = new int[366];
 *         dp[0] = 0;
 *
 *         for (int i = 1; i <= 365; i++) {
 *             dp[i] = dp[i-1]; //保存最新的最优解
 *             if (isTravel[i]){
 *                 // 如果当前有旅行计划,计算当前最优解
 *                 //核心解决
 *                 dp[i] = Math.min(dp[Math.max(0, i-7)] + costs[1],
 *                                 Math.min(dp[Math.max(0, i-1)] + costs[0], dp[Math.max(0, i-30)] + costs[2]));
 *             }
 *         }
 *
 *         for (int i : dp) {
 *             System.out.print(i + " ");
 *         }
 *         System.out.println();
 *         return dp[365];
 * @author: wxq
 * @date 2019-05-22 21:47
 **/
public class Solution_646_dp {

    static class Node implements Comparable{
        int left;
        int right;
        Node(int left, int right){
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Object o) {
            Node node = (Node)o;
            if (this.left < node.left){
                return -1;
            }else if(this.left > node.left){
                return 1;
            }else {
                return 0;
            }
        }

        @Override
        public String toString() {
            return left + " " + right;
        }
    }

    public static int findLongestChain(int[][] pairs) {
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < pairs.length; i++) {
            list.add(new Node(pairs[i][0], pairs[i][1]));
        }
        Collections.sort(list);
        int[] dp = new int[list.size()];
        Arrays.fill(dp, 1);
        int maxlen = 0;
        for (int i = 0; i < list.size(); i++) {
            Node node1 = list.get(i);
            for (int j = 0; j < i; j++) {
                if (node1.left > list.get(j).right){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }

            }

            if (dp[i] > maxlen){
                maxlen = dp[i];
            }
        }

        return maxlen;
    }

    public static void main(String[] args) {
        int[][] pairs =new int[][]{
                {-7, -1}, {0, 10}, {2, 3}, {3, 6}, {3, 10}, {4, 5}, {7, 9}, {7, 9}
        };
        System.out.println(findLongestChain(pairs));
    }
}
