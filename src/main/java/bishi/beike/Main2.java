package bishi.beike;


import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int a = 4, b = 5;
//        int count = 0;
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int count = 0;

        if(b > a){
            while(b > a){
                if(b%2 != 0){
                    b = b + 1;
                    count++;
                }
                b = b/2;
                count++;
            }
        }
        if(b <= a){
            count = count + a - b;
        }
        System.out.println(count);
    }
}
