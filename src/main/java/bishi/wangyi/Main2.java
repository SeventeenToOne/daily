package bishi.wangyi;

import java.util.Scanner;

//
//        题目描述
//        牛牛以前在老师那里得到了一个正整数数对(x, y), 牛牛忘记他们具体是多少了。
//
//        但是牛牛记得老师告诉过他x和y均不大于n, 并且x除以y的余数大于等于k。
//        牛牛希望你能帮他计算一共有多少个可能的数对。
//
//        输入描述:
//        输入包括两个正整数n,k(1 <= n <= 10^5, 0 <= k <= n - 1)。
//        输出描述:
//        对于每个测试用例, 输出一个正整数表示可能的数对数量
public class Main2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int n = scan.nextInt();
            int k = scan.nextInt();
            Long sum = 0l;
            for(int y = Math.max(1, k); y <= n; y++){
                long res = 0;
                res = n/y * (y - k);
                if(n%y >= k){
                    if(k > 0){
                        res += n%y - k + 1;
                    }else {
                        res += n%y;
                    }

                }
                sum += res;
            }
            System.out.println(sum);
        }
    }
}
