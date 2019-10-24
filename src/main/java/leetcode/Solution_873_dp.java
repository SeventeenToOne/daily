package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: algorithms
 * @description:
 * @author: wxq
 * @date 2019-05-28 22:08
 **/
public class Solution_873_dp {
    private int[][] dp;
    public int lenLongestFibSubseq(int[] A) {
        dp = new int[A.length][A.length];
        //初始化元素
//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp[i].length; j++) {
//                dp[i][j] = 2;
//            }
//        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 2;
        }

        // 建立索引方便快速查找
        Map<Integer, Integer> valueIndex = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            valueIndex.put(A[i], i);
        }
        int max = 2;
        for (int i = 1; i < A.length; i++) {
            for (int j = i+1; j < A.length; j++) {
                int value = A[j] - A[i];
                if (valueIndex.containsKey(value) && valueIndex.get(value) < i){
                    int k = valueIndex.get(value);
                    dp[i][j] = Math.max(dp[i][j], dp[k][i] + 1);
                    if (max < dp[i][j]){
                        max = dp[i][j];
                    }
                }else {
                    //关键
                    dp[i][j] = 2;
                }
            }
        }

        int row = 0;
        for (int[] ints : dp) {
            System.out.print(row++ + ": ");
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        return max == 2 ? 0 : max;

    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(new Solution_873_dp().lenLongestFibSubseq(a));

        int[] b = new int[]{1,3,7,11,12,14,18};
        System.out.println(new Solution_873_dp().lenLongestFibSubseq(b));

        int[] c = new int[]{2,4,7,8,9,10,14,15,18,23,32,50};
        System.out.println(new Solution_873_dp().lenLongestFibSubseq(c));
    }
}
