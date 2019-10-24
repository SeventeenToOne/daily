package bishi.youzan2019;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = Integer.valueOf(scan.nextLine());
        int[] roads = new int[N];
        int sumRoad = 0;
        int maxLen = 0;
        String str = scan.nextLine();
        String[] arr = str.split(",");
        roads[0] = Integer.valueOf(arr[0]);
        for (int i = 1; i < N; i++) {
            roads[i] = Integer.valueOf(arr[i]);
            sumRoad += Math.abs(roads[i] - roads[i-1]);
        }


        for(int x = 1; x < N-1; x++){
            int dis = Math.abs(roads[x] - roads[x-1])
                    + Math.abs(roads[x] - roads[x+1])
                    - Math.abs(roads[x-1] - roads[x+1]);

            if(dis > maxLen){
                maxLen = dis;
            }
        }

        System.out.println(sumRoad - maxLen);

    }
}
