package bishi.wangyi2019;

import java.util.Arrays;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        int t;
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n ;
            int[] a = new int[100005];
            n = scanner.nextInt();
            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextInt();
            }
            Arrays.sort(a, 0, n);
            int mark = 0;
            for (int j = n-1; j > 2; j--){
                if(a[j] >= a[j-1] + a[j-2]){
                    mark = 1;
                    break;
                }
            }
            if(mark == 1){
                System.out.println("NO");
            }else {
                System.out.println("YES");
            }
        }
    }
}
