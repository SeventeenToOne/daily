package alg.Graph;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;

/**
 * @program: algorithms
 * @description: 无向图相关的设定 P333
 * @author: wxq
 * @date 2019-05-21 15:25
 **/
public class Graph {
    private final int V;
    private int E;
    private ArrayList<Integer>[] adj;

    /**
     *
     * 从输入流中读入一幅图
     *
     * @author wxq
     * @date 2019-7-8
    */
    public Graph(In in){
        this(in.readInt());

        //从输入流中建立表
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    
    public Graph(int v){
        this.V = v;
        this.E = 0;
        adj = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public int V(){ return V;}

    public int E(){ return E;}


    public void addEdge(int v, int w){
        // 无向图添边, 需要在两个节点的邻接表中添加
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    @Override
    public String toString() {
        return GeneralGarphUtils.toString(this);
    }
}
