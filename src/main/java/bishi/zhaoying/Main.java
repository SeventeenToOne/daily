package bishi.zhaoying;

import java.util.Scanner;

/**
 * @program: algorithms
 * @description:
 * @author: wxq
 * @date 2018-09-25 16:27
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strings = str.split(" ");
        int[] prices = new int[strings.length];
        int length = strings.length;
        for (int i = 0; i < strings.length; i++) {
            prices[i] = Integer.valueOf(strings[i]);
        }

        System.out.println(maxProfit(prices, length));
    }

    public static int maxProfit(int[] prices, int length) {
        int res = 0;
        int dp[][] = new int[length][length];
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                dp[i][j] = prices[j] - prices[i];
                System.out.print(dp[i][j] + " ");
            }

        }

        int max = 0;
        int ma2 = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < length; i++)
            for (int j = i + 1; j < length; j++) {
                if (dp[i][j] > max) {
                    max = dp[i][j];
                    start = i;
                    end = j;
                }
            }
        System.out.println(start + " " + end + " " + max);
        for (int i = 0; i < start; i++)
            for (int j = i + 1; j < start; j++) {
                if (dp[i][j] > ma2) {
                    ma2 = dp[i][j];

                }
            }

        if (end < length - 1)
            for (int i = end + 1; i < length; i++) {
                for (int j = i + 1; j < length; j++) {
                    if (dp[i][j] > ma2) {
                        ma2 = dp[i][j];

                    }
                }
            }
        res = max + ma2;
        return res;
    }

}
