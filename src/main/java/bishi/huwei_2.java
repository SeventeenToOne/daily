package bishi;

import java.util.Scanner;

/**
 * @program: algorithms
 * @description: 华为笔试第二题最长子串
 * @author: wxq
 * @date 2018-08-01 19:11
 **/
public class huwei_2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int[] chartsLens = new int[200];
        for (int i = 0; i < chartsLens.length; i++) {
            chartsLens[i] = 0;
        }

        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i);
            chartsLens[index]++;
        }
        int max = 0, maxIndex = 0;
        for (int i = 0; i < chartsLens.length; i++) {
            if(chartsLens[i] > max){
                max = chartsLens[i];
                maxIndex = i;
            }
        }
        for (int i = 0; i < max; i++) {
            System.out.print((char)maxIndex);
        }
        System.out.println();
        System.out.println(max);

    }
}
