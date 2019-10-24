package leetcode;

/**
 * @program: algorithms
 * @description:
 * @author: wxq
 * @date 2019-05-27 20:35
 **/
public class Solution_718_dp {
    public static int findLength(int[] A, int[] B) {
        int[][] dp = new int[A.length + 1][B.length + 1];
        int max = 0;
        for (int i = 0; i < dp[0].length; i++){
            dp[0][i] = 0;
        }

        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i-1] == B[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = 0;
                }

                if(max < dp[i][j]){
                    max = dp[i][j];
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return max;

    }

    public static void main(String[] args) {

        int[] a = new int[]{0,1,1,1,1};
        int[] b = new int[]{1,0,1,0,1};
        System.out.println(findLength(a, b));
    }
}
