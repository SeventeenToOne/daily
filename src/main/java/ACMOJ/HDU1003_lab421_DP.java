package ACMOJ;

import java.util.Scanner;

/**
 * @program: algorithms
 * @description: dp
 * @author: wxq
 * @date 2018-06-28 20:33
 **/
public class HDU1003_lab421_DP {

    public static int initValue = Integer.MAX_VALUE - 1000000000;

    // 在ca 容量下, 装满的情况下,价值最小是多少
    public static int bag(int[] weights, int[] values, int ca){
        int[] dp = new int[ca+1];

        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = initValue;
        }

        for(int i = 0; i < weights.length; i++){
            for(int j = weights[i]; j <= ca; j++){
//                dp[j] = min(dp[j], dp[j - weights[i]] + values[i]);

                if(dp[j] > dp[j - weights[i]] + values[i]){
                    dp[j] = dp[j - weights[i]] + values[i];
                }
            }
        }

//        //out
//        for (int i : dp) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
//        System.out.println(dp[ca]);

        return dp[ca];
    }

    public static int min(int a, int b){
        return a < b ? a: b;
    }


    /*
    *  1 10 110 2 1 1 30 50
    *  3 10 110 2 1 1 30 50 10 110 2 1 1 50 30 1 6 2 10 3 20 4
    *  1 10 110 2 1 3 4 4
    *  4 10 110 2 1 1 30 50 10 110 2 1 1 50 30 1 6 2 10 3 20 4 0 110 2 1 3 4 4
    * */
    public static void main(String[] args){
//        int[] weights = {3, 4};
//        int[] values = {1, 30};
//        int c = 5;
        // 多少个样例
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        while((N--) > 0){
            int E, F, capacity;
            E = scanner.nextInt();
            F = scanner.nextInt();
            capacity = F - E;
            
            int countCoin  = scanner.nextInt();
            int[] weights = new int[countCoin];
            int[] values = new int[countCoin];
            for (int i = 0; i < countCoin; i++) {
                values[i] = scanner.nextInt();
                weights[i] = scanner.nextInt();
            }

            int minValue = bag(weights, values, capacity);
            if(minValue == initValue){
                System.out.println("This is impossible.");
            }else {
                System.out.println("The minimum amount of money in the piggy-bank is " + minValue + ".");
            }
        }
    }


}
