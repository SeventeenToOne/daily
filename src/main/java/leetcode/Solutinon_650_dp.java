package leetcode;

/**
 * @program: algorithms
 * @description:
 * @author: wxq
 * @date 2019-05-28 20:56
 **/
public class Solutinon_650_dp {
    public static int minSteps(int n) {
        if (n <=1 ){
            return 0;
        }

        boolean[] marked = new boolean[n+1];
        int[] dp = new int[n + 1];
        dp[1] = 0;
        dp[2] = 2;
        marked[0] = false; marked[1] = false;
        for (int i = 3; i <= n; i++) {
            marked[i] = false;
            int maxSubnum = subNum(i);
            if (maxSubnum == 1){
                dp[i] = i;
            }else {

                System.out.println(i + " " + maxSubnum + " " + marked[i - maxSubnum]);
                if (!marked[i - maxSubnum]){
                    dp[i] = Math.min(i, dp[i-maxSubnum]+2);
                    marked[i - maxSubnum] = true;
                }else {
                    dp[i] = Math.min(i, dp[i-maxSubnum]+1);
                }
                if (marked[6])
                    System.out.println(i + "-------------");
            }
        }

        for (int i : dp) {
            System.out.print(i + " ");
        }
        System.out.println();

        return dp[n];

    }

    public static int subNum(int num){
        int maxSubNum = 1;
        for (int i = 2; i <= num/2; i++) {
            int temp = num;
            while (temp > 0){
                temp = temp - i;
            }
            if (temp == 0 && maxSubNum < i){
                maxSubNum = i;
            }
        }
        return maxSubNum;
    }


    public static void main(String[] args) {
        System.out.println(minSteps(9));
        System.out.println(minSteps(13));
    }
}
