package leetcode;

import sun.text.resources.cldr.naq.FormatData_naq;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: algorithms
 * @description:
 * @author: wxq
 * @date 2019-05-24 20:04
 **/
public class Solutinon_764_dp {
    public static int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] dp = new int[N][N];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = N;
            }
        }

        for (int i = 0; i < mines.length; i++) {
                dp[mines[i][0]][mines[i][1]] = 0;
        }

//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp[i].length; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();

        for (int k = 0; k < N; k++) {
            int leftNum = 0, rightNum = 0, topNum = 0, bottom = 0;
            for (int i = 0, j = N-1 ; i < N; i++, j--) {
                topNum = dp[i][k] == 0 ? 0 : topNum + 1;
                dp[i][k] = Math.min(topNum, dp[i][k]);

                bottom = dp[j][k] == 0 ? 0 : bottom + 1;
                dp[j][k] = Math.min(bottom, dp[j][k]);

                leftNum = dp[k][i] == 0? 0: leftNum+1;
                dp[k][i] = Math.min(dp[k][i], leftNum);

                rightNum = dp[k][j] == 0? 0: rightNum+1;
                dp[k][j] = Math.min(dp[k][j], rightNum);

            }
        }
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                //System.out.print(dp[i][j] + " ");
                if(max < dp[i][j]){
                    max = dp[i][j];
                }
            }
         //   System.out.println();
        }

        return max;
    }

    public static void main(String[] args) {
        int[][] mines = new int[][]{{0,0},{0,1},{0,2},{0,7},{1,2},{1,3},{1,9},{2,3},{2,5},{2,7},{2,8},{3,2},{3,5},
                {3,7},{4,2},{4,3},{4,5},{4,7},{5,1},{5,4},{5,8},{5,9},{7,2},{7,5},{7,7},
                {7,8},{8,5},{8,8},{9,0},{9,1},{9,2},{9,8}};
        int n = 10;
        System.out.println(orderOfLargestPlusSign(n, mines));
    }
}
