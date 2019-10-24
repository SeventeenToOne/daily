package bishi.jingdong;

import java.util.*;

public class Main {

    public static boolean compare(int[] l1, int[] l2, int[] l3, int i, int j){
        if (l1[i] < l1[j] && l2[i] < l2[j] && l3[i] < l3[j]) {
            return true;
        }else {
            return false;
        }

    }

    public static void main(String[] args) {
        int count = 0 ;
        Scanner input = new Scanner(System.in);
        int num = input.nextInt() ;

        int[] local1 = new int[num],local2 = new int[num], local3 = new int[num];

        for(int i = 0 ; i < num ; ++ i){
            local1[i] = input.nextInt() ;
            local2[i] = input.nextInt() ;
            local3[i] = input.nextInt() ;
        }
        for(int i = 0 ; i < num ; ++ i){
            for(int j = 0 ; j < num ; ++ j){
                if(compare(local1, local2, local3, i, j)){
                    count ++ ;
                    break ;
                }
            }
        }
        System.out.println(count);
    }

}