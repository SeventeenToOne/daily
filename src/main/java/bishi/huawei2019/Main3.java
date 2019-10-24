package bishi.huawei2019;

import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int low = scan.nextInt();
        int hight = scan.nextInt();

        int ten = 0, sigle = 0;

        for (int i = low; i < hight; i++){
            boolean isPrime = true;
            for(int j = 2; j < Math.sqrt(i) + 1; j++){
                if(i % j == 0){
                    isPrime = false;
                    break;
                }
            }

            if(isPrime){
                System.out.println(i);
                int val = i;
                if(val < 10){
                    sigle += val;
                }else {
                    sigle += val % 10;
                    ten += (val / 10) % 10;
                }
            }
        }

        if(ten > sigle){
            System.out.println(sigle);
        }else {
            System.out.println(ten);
        }


    }
}

// 151 160
