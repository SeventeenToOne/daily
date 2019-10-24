package alg.sort;

import java.util.Scanner;


public class QuickSimple {
    public static void sort(int[] a){
        sort(a, 0, a.length-1);
    }

    private static void sort(int[] a, int lo, int hi){
        if( hi <= lo) return;
        // 切分
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    private static int partition(int[] a, int lo, int hi){

        int v = a[lo];
        int i = lo;
        int j = hi+1;

        while(true){
            while(a[++i] < v)  if(i == hi) break;
            while(v < a[--j])  if(j == lo) break;
            if(i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private static void exch(int[] a, int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args){
//        int[] a = {5, 10, 9, 1, 2, 3};
//        int[] a1 = {10, 12, 1, 5, 9, 12 ,13 ,3, 6, 6, 15};
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int N = scanner.nextInt();
            int[] a = new int[N];

            for (int i = 0; i < a.length; i++) {
                a[i] = scanner.nextInt();
            }
            sort(a);
            for (int i = 0; i < a.length; i++) {
                if(i < a.length - 1){
                    System.out.print(a[i] + " ");
                }else {
                    System.out.println(a[i]);
                }
            }


        }
    }

}
