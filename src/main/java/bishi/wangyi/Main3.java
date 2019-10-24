package bishi.wangyi;

//        牛牛准备参加学校组织的春游, 出发前牛牛准备往背包里装入一些零食, 牛牛的背包容量为w。
//        牛牛家里一共有n袋零食, 第i袋零食体积为v[i]。
//        牛牛想知道在总体积不超过背包容量的情况下,他一共有多少种零食放法(总体积为0也算一种放法)。
//        输入描述:
//        输入包括两行
//        第一行为两个正整数n和w(1 <= n <= 30, 1 <= w <= 2 * 10^9),表示零食的数量和背包的容量。
//        第二行n个正整数v[i](0 <= v[i] <= 10^9),表示每袋零食的体积。
//        输出描述:
//        输出一个正整数, 表示牛牛一共有多少种零食放法。

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    private static int count = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int bagWeight = scan.nextInt();
        int[] foods = new int[n];
        Long foodTotal = 0l;
        for (int i = 0; i < n; i++) {
            foods[i] = scan.nextInt();
            foodTotal += foods[i];
               // System.out.println(foods[i]);
        }

//        for (int food : foods) {
//            System.out.println(food);
//        }

        if(foodTotal <= bagWeight){
            System.out.println((long)Math.pow(2, n) );
        }else {
            dfs(0, 0, n, foods, bagWeight);
            //System.out.println(bagWeight);
            System.out.println(count + 1);
        }



    }

    private  static void dfs(long sum, int cur, int n, int[] foods, int bagWeight){
        if(cur < n){
            if(sum > bagWeight){
                return;
            }

            dfs(sum, cur+1, n, foods, bagWeight);

            if(sum + foods[cur] <= bagWeight){
                count++;
                dfs(sum + foods[cur], cur+1, n, foods, bagWeight);
            }
        }
    }




// 动态规划失败
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int n = scan.nextInt();
//        int bagWeight = scan.nextInt();
//        int[] foods = new int[n];
//        for (int i = 0; i < n; i++) {
//            foods[i] = scan.nextInt();
//        }
//        int[] sums = new int[bagWeight+1];
//        Arrays.fill(sums, 0);
//        sums[0] = 1;
//        for (int i = 0; i < foods.length; i++) {
//            ZeroOnePack(sums, foods[i],  bagWeight);
//        }
//        for (int sum : sums) {
//            System.out.print(sum + " ");
//        }
//        System.out.println();
//        System.out.println(sums[bagWeight] + 1);
//
//
//    }
//
//    public static void ZeroOnePack(int[] f, int c, int bagWeight){
//        for(int i = bagWeight; i >= c; i--){
//            f[i] = f[i] + f[i-c] + 1;
//        }
//    }
//
//    public static void CompletePack(int[] f, int c, int bagWeight){
//        for(int i = c; i <= bagWeight; i++){
//            f[i] = f[i] + f[i-c];
//        }
//    }

}
