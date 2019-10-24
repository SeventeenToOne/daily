package bishi.beike;

import java.util.Scanner;


public class Main {
    static int len = 0;
    static int[] family = new int[40001];
    public static int max(int a, int b){

        if(len < a){
            len = a;
        }

        if(len < b){
            len = b;
        }
        return len;
    }

    public static boolean isFather(int a){
        while (a > 0) a = family[a];
        if(a < 0){
           return true;
        }
        return false;
    }

    public static boolean isFather(int father, int sun){
        while (sun > 0 && sun != father) sun = family[sun];

        if(sun < 0){
            return false;
        }
        if(sun == father){
            return true;
        }else {
            return false;
        }

    }

    public static void main(String[] args) {
        for (int i = 0; i < family.length; i++) {
            family[i] = 0;
        }
        Scanner scanner = new Scanner(System.in);

//        int[] example = {10, 1, -1, 3,  1, 4, 1, 5, 1, 6,1, 7,1, 8,1, 9,1, 10,1, 2, 10, 5, 1,2, 2,3, 2,4, 2,5, 2,10};
//        int num = example[0];
        int num = scanner.nextInt();
        for (int i = 1; i <= num; i++) {
//            int a = example[2*i-1];
//            int b = example[2*i];
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            len = max(a, b);
            if(isFather(a)){
                family[b] = a;
            }else {
                family[a] = b;
            }
        }

//        for (int i = 0; i < len+1; i++) {
//            System.out.print(family[i] + " ");
//        }

//        int testNum = example[21];
        int testNum = scanner.nextInt();
        int[] res = new int[testNum];
        for (int i = 1; i <= testNum; i++) {
//            int a = example[21 + 2*i-1];
//            int b = example[21 + 2*i];
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            if (isFather(a, b)) {
                System.out.print(1);
            }else if (isFather(b , a)){
                System.out.print(2);
            }else {
                System.out.print(0);
            }

            if (testNum != i){
                System.out.println();
            }

        }



    }
}
