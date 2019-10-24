package bishi.wangyi2019;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        int[] source = new int[160];
        int[] person = new int[10005];
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int s = scanner.nextInt();
            person[i] = s;
            source[s]++;
        }
        int sum = 0;
        for (int i = 0; i < 160; i++) {
            sum += source[i];
            source[i] = sum;
        }
        int q = scanner.nextInt();
        BigDecimal fenmu = new BigDecimal(n);
        ArrayList<BigDecimal> res = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            int index = scanner.nextInt() - 1;
            int low = ( source[person[index]] -1 )* 100;
            BigDecimal fenzi = new BigDecimal(low);
            BigDecimal result = fenzi.divide(fenmu, 6, BigDecimal.ROUND_HALF_UP);
            //System.out.println(result);
            res.add(result);
        }

        for (BigDecimal re : res) {
            System.out.println(re);
        }

    }
}
