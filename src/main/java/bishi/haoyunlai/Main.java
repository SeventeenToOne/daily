package bishi.haoyunlai;



import java.math.BigInteger;
import java.util.Scanner;
/*
*  边界值判断失误
* */

public class Main {
    public static String caculaCount(String a){
        int count = 0 ;
        if(a.length() < 2){
            return a;
        }
        if(a.length() < 3){
            int aI = Integer.valueOf(a);
            int l1 = aI / 10;
            int l2 = aI % 10;
            if(l1 > l2){
                return String.valueOf(9 + l1 - 1);
            }else {
                return String.valueOf(9 + l1);
            }
        }

        int n = a.length();
        count = 18;
        int i = 3;
        for(i = 3; i < n; i++){
            count += 9 * Math.pow(10, (i-2));
        }
//        System.out.println( "::" + (a.charAt(0) - '1'));
        count += (a.charAt(0) - '1') * Math.pow(10, (i-2));

        if((int) a.charAt(0) > (int) a.charAt(a.length() - 1)){
            count--;
        }
        if((int) a.charAt(0) == (int) a.charAt(a.length() - 1)){
            count++;
        }
        String b = a.substring(1, a.length()-1);
//        System.out.println("b:" + b + " count:" + count);
        BigInteger res = new BigInteger(b);
        res = res.add(BigInteger.valueOf(count)).add(BigInteger.valueOf(1));
        return res.toString();

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();
//        System.out.println(caculaCount(a));
//        System.out.println(caculaCount(b));
        BigInteger big1 = new BigInteger(caculaCount(a));
        BigInteger big2 = new BigInteger(caculaCount(b));
        BigInteger res = new BigInteger("0");
        res = big2.subtract(big1);
        System.out.println(res);

//        System.out.println(caculaCount("1"));
//        System.out.println(caculaCount("10"));
//        System.out.println(caculaCount("1000"));
//        System.out.println(caculaCount("103"));

    }
}
