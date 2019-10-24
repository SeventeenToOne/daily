package leetcode;

import java.util.Arrays;

/**
 * @program: algorithms
 * @description:
 * 给定一个方形整数数组 A，我们想要得到通过 A 的下降路径的最小和。
 *
 * 下降路径可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列。

 * 示例：
 *
 * 输入：[[1,2,3],[4,5,6],[7,8,9]]
 * 输出：12
 * @author: wxq
 * @date 2019-05-08 21:26
 **/
public class Solution_931_dp {


    public static int minFallingPathSum(int[][] A) {
        if (A == null){
            return 0;
        }
        int jLenA = A[0].length;
        int[][] t = new int[A.length][jLenA];

        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                if (i  == 0){
                    t[i][j] = A[i][j];
                }else {
                    t[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < A.length ; i++) {
            for (int j = 0; j < jLenA; j++) {
                int leftVal, midVal, rightVal;
                //判断左上位置是否有元素.
                if(j-1 >= 0){
                    leftVal = t[i-1][j-1];
                }else {
                    leftVal = Integer.MAX_VALUE;
                }
                //正上方元素.
                midVal =  t[i-1][j];

                //判断右上方否有元素.
                if( j+1 < jLenA){
                    rightVal =  t[i-1][j+1];
                }else {
                    rightVal = Integer.MAX_VALUE;
                }
                t[i][j] = A[i][j] + Math.min(leftVal, Math.min(midVal, rightVal));
            }
        }
        int minRoodLen = Integer.MAX_VALUE;
        for (int i = 0; i < t[t.length - 1].length; i++) {
            if ( t[t.length - 1][i] < minRoodLen){
                minRoodLen =  t[t.length - 1][i];
            }

        }

        return minRoodLen;
    }

    public static void main(String[] args) {
//        [[-80,-13,22],[83,94,-5],[73,-48,61]]
        int[][] a = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] b = new int[][]{{-80,-13,22}, {83,94,-5}, {73,-48,61}};

        System.out.println(minFallingPathSum(a));
        System.out.println(minFallingPathSum(b));
    }
}
