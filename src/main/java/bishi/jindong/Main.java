package bishi.jindong;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int[] stus = new int[N];
        for (int i = 0; i < N; i++) {
            stus[i] = scan.nextInt();
        }
        if(N <= 0){
            System.out.println(0);
        }
        int groupNum = 1;
        int preHiggh = stus[0];
        for (int i = 1; i < stus.length; i++) {
            if(preHiggh < stus[i]){
                groupNum++;
            }
            if(preHiggh == stus[i]){
                int j = i ;
                while(j < stus.length && stus[j] == preHiggh){
                    j++;
                }
                if(j == stus.length){
                    break;
                }
                if(preHiggh > stus[j]){
                    preHiggh = stus[j];
                    i = j;
                    continue;
                }else {
                    groupNum = groupNum + 1;
                    preHiggh = stus[j];
                    i = j;
                    continue;
                }

            }
            preHiggh = stus[i];
        }

        System.out.println(groupNum);

    }
}
/*
4
2 1 3 2

10
69079936 236011312 77957850 653604087 443890802 277126428 755625552 768751840 993860213 882053546
* */
