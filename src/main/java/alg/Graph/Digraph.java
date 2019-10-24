package alg.Graph;

import edu.princeton.cs.algs4.In;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: algorithms
 * @description: 有向图
 * @author: wxq
 * @date 2019-05-24 11:22
 **/
public class Digraph {
    private final int V;
    private int E;
    private ArrayList<Integer>[] adj;

    public Digraph(int v){
        this.V = v;
        adj = new ArrayList[v];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public Digraph(In in){
       this(in.readInt());
       int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
        E++;
    }
    public Digraph reverse(){
        Digraph g = new Digraph(V);
        for (int i = 0; i < V; i++) {
            for (Integer v : adj[i]) {
                g.addEdge(v, i);
            }
        }

        return g;
    }


    public static void main(String[] args) {
        String tinyDG = "src/main/java/alg/Graph/tinyDG.txt";
        Digraph digraph = new Digraph(new In(tinyDG));
        System.out.println(digraph.V);
        for (int i = 0; i < digraph.V(); i++) {
            System.out.print(i + ": ");
            for (Integer v : digraph.adj(i)) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

}
