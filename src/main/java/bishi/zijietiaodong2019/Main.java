package bishi.zijietiaodong2019;


import java.util.Scanner;

public class Main {
    static boolean[] marked;
    static int count = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[][] m = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int num = scan.nextInt();
                m[i][j] = num >=3 ? num : 0;
            }
        }
        marked = new boolean[N];
        for (int s = 0; s < N; s++) {
            if(!marked[s]){
                dfs(m, s);
                count++;
            }
        }

        System.out.println(count);
    }

    public static void dfs(int[][] G, int v){
        marked[v] = true;
        for (int w = v; w < G[v].length; w++){
            if(G[v][w] >= 3 && !marked[w]){
                dfs(G,  w);
            }
        }
    }

}

//豆油

/*
3
0 4 0
4 0 6
0 6 0

3
0 4 0
4 0 0
0 0 0
* */
