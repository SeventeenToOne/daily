package bishi.zijietiaodong2019;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Main4 {
    static boolean[] marked;
    static int[] ids;
    static int count = 0;
    static int[] idNum;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        if(N <= 0){
            System.out.println(0);
        }
        BigInteger[] weights = new BigInteger[N];
        //int[] w  = new int[N];

        ids = new int[N];
        marked = new boolean[N];
        idNum = new int[N];
        Graph g = new Graph(N);






        BigInteger b2 = new BigInteger("2");
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                BigInteger com = weights[i].gcd(weights[j]);
                System.out.println("com:" + com + " wi:" + weights[i] + " wj:" + weights[j]);

                if(com.compareTo(b2) >= 0){
                    g.addEdge(i, j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if(!marked[i]){
                dfs(g, i);
                count++;
            }
        }

        int maxCount = 0;
        for (int num : idNum) {
            if(num > maxCount){
                maxCount = num;
            }
        }

        System.out.println(maxCount);
    }

    public static void dfs(Graph g, int v){
        marked[v] = true;
        ids[v] = count;
        idNum[count]++;

        for (Integer w : g.adj(v)) {
            if(!marked[w]){
                dfs(g, w);
            }
        }
    }

}

class Graph {
    private final int V;
    private int E;
    private ArrayList<Integer>[] adj;


    public Graph(int v){
        this.V = v;
        this.E = 0;
        adj = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(int v, int w){
        // 无向图添边, 需要在两个节点的邻接表中添加
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

}

/*
6
20 50 22 74 9 63
* */
