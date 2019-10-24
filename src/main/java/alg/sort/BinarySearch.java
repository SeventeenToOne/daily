package alg.sort;

import java.util.Arrays;
import java.util.Scanner;


public class BinarySearch {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()){
            int N = scanner.nextInt();
            int[] keys = new int[N];
            for (int i = 0; i < N; i++) {
                keys[i] = scanner.nextInt();
            }
            int searchKey = scanner.nextInt();
            Arrays.sort(keys);
            //
            int lo = 0;
            int hi = keys.length - 1;
            int mid  = 0 ;
            while(lo <= hi){
                mid = lo + (hi - lo) / 2;
                if(searchKey > keys[mid]){
                    lo = mid + 1;
                }else if( searchKey < keys[mid]){
                    hi = mid - 1;
                }else {
                    break;
                }
            }

            if(lo > hi && keys[mid] != searchKey){
                System.out.println("no");
            }else {
                System.out.println(mid);
            }
        }

    }
}
