package bishi.guazi;

import java.util.Scanner;

/**
 * @program: algorithms
 * @description: 1
 * @author: wxq
 * @date 2018-09-04 18:23
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] resSplit = input.split(" ");
        for (int i = resSplit.length - 1; i >= 0; i--) {
            System.out.print(resSplit[i]);
            if(i != 0){
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
