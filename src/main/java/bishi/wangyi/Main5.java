package bishi.wangyi;

import java.util.Scanner;

/*题目描述
        又到了丰收的季节，恰逢小易去牛牛的果园里游玩。
        牛牛常说他对整个果园的每个地方都了如指掌，小易不太相信，所以他想考考牛牛。
        在果园里有N堆苹果，每堆苹果的数量为ai，小易希望知道从左往右数第x个苹果是属于哪一堆的。
        牛牛觉得这个问题太简单，所以希望你来替他回答。
        输入描述:
        第一行一个数n(1 <= n <= 105)。
        第二行n个数ai(1 <= ai <= 1000)，表示从左往右数第i堆有多少苹果
        第三行一个数m(1 <= m <= 105)，表示有m次询问。
        第四行m个数qi，表示小易希望知道第qi个苹果属于哪一堆。
        输出描述:
        m行，第i行输出第qi个苹果属于哪一堆。

5
2 7 3 4 9
3
1 25 11

        */
public class Main5 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] apples = new int[n + 1];
        apples[0] = 0;
        for(int i =  1; i <= n; i++){
            apples[i] = apples[i-1] + scan.nextInt();
        }
        int m = scan.nextInt();
        int[] querys = new int[m];
        for (int i = 0; i < m; i++) {
            querys[i] = scan.nextInt();
        }
        for (int query : querys) {
            int low = 1, high = n;
            while(low <= high){
                int mid = low + (high - low) / 2;
                if(query <= apples[mid] && query > apples[mid-1]){
                    System.out.println(mid);
                    break;
                }
                if(query < apples[mid]){
                    high = mid - 1;
                }

                if(query > apples[mid]){
                    low = mid + 1;
                }
            }
            if(low > high){
                System.out.println("Error");
            }
        }

    }
}
