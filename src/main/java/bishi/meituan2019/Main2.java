package bishi.meituan2019;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        boolean flag = true;

        for (int i = 1; i <= n; i++) {
            if(i % 2 == 0){
                if (flag){
                    System.out.print("B");
                    flag = false;
                }else {
                    System.out.print("C");
                    flag = true;
                }
            }else {
                System.out.print("A");
            }
        }

        System.out.println();

    }
}
