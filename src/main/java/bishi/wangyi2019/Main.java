package bishi.wangyi2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
4 3
        1 3 2  4
        4
        3
        14 3
        1 2 3 4
        4
        3
        1
        */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int q = scan.nextInt();
        int[] arrays = new int[n];
        int[] querys = new int[q];
        for (int i = 0; i < n; i++) {
            arrays[i] = scan.nextInt();
        }
        for (int i = 0; i < q; i++) {
            querys[i] = scan.nextInt();
        }
        Arrays.sort(arrays);
//        for (int array : arrays) {
//            System.out.println(array);
//        }
        for (int query : querys) {
            int low = 0, hight = arrays.length - 1;
            boolean flag = false;
            while (low <= hight){
                int mid = low + (hight-low) / 2;
                if(query > arrays[mid]){
                    low = mid + 1;
                    continue;
                }
                if(query <= arrays[mid]){
                    int i = mid;
                    for (i = mid; i >=0; i--){
                        if(query > arrays[i]){
                            break;
                        }
                    }
                    flag = true;
                    System.out.println(arrays.length - i - 1);
                    for (int j = i + 1; j < arrays.length; j++){
                        arrays[j] = arrays[j] - 1;
                    }
                    break;
                }

            }
            if(!flag){
                System.out.println(0);
            }
            Arrays.sort(arrays);

        }
    }
}
