package bishi.zhaoshang2019;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String minStr = str.replaceAll("\\?", "0");
        String maxStr = str.replaceAll("\\?", "9");


        int minVal = Integer.valueOf(minStr);
        int maxVal = Integer.valueOf(maxStr);
//        System.out.println(minVal);
//        System.out.println(maxVal);

        int count = 0;
        while (minVal <= maxVal){
            if (minVal % 13 == 5){
                count++;
            }
            minVal++;
        }

        System.out.println(count % ((int) Math.pow(10, 9) + 7));


    }
}


