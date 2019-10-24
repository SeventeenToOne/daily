package bishi.youdao2019;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        while(num > 0){

            int n = scan.nextInt();
            int m = scan.nextInt();
            int[] heaps = new int[n];
            for (int i = 0; i < heaps.length; i++) {
                heaps[i] = scan.nextInt();
            }

            //当前背包容量
            BigInteger bag = new BigInteger(String.valueOf(m));
            // 是否可以完成
            boolean isFinsh = true;
            for (int i = 0; i < heaps.length; i++) {
                if(i == 0){
                    // 将当前堆减至最小
                    if(heaps[i] != 0){
                        bag = bag.add(new BigInteger( String.valueOf( heaps[i]) ) );
                        heaps[i] = 0;
                    }

                }else {
                    int curMinVal = heaps[i-1] + 1;
                    if(curMinVal > heaps[i]){
                        //当前堆小于最小值，需要增加
                        int subVal = curMinVal - heaps[i];
                        //bag < subVal
                        if (bag.compareTo( new BigInteger(String.valueOf(subVal))) < 0){
                            isFinsh = false;
                            break;
                        }

                        heaps[i] = curMinVal;
                        bag = bag.subtract(new BigInteger(String.valueOf(subVal)));


                    }else if (curMinVal < heaps[i]){
                        //当前堆大于最小值，需要减小堆
                        int subVal = heaps[i] - curMinVal;
                        heaps[i] = curMinVal;
                        bag = bag.add(new BigInteger(String.valueOf(subVal)));

                    }

                }
            }

            if (isFinsh){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }


            num--;
        }
    }
}
/*
1
5 3
2 2 3 3 1

1
5 2
0 0 1 2 1

2
5 2
0 0 1 2 1
5 3
2 2 3 3 1

1
1 0
1

1
5 2
1 2 3 4 1


1
5 2
10000000 1000000001 10000000  10000000  10000000
* */