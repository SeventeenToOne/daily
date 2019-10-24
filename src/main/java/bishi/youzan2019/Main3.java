package bishi.youzan2019;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.nextLine();
        String b = scan.nextLine();
        int blen = b.length();
        int num = 0;
        for (int i = 0; i < a.length() - blen + 1; i++) {
            String temp = a.substring(i, i + blen);
            if(b.equals(temp)){
                num++;
            }
        }

        System.out.println(num);
    }
}
/*
zyzyzyz
zyz

zxzyzyz
zyz

zzzxxxz
zyz
* */
