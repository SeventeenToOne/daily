package alg.Graph;

import edu.princeton.cs.algs4.In;

import java.util.LinkedList;

/**
 * @program: algorithms
 * @description:
 * @author: wxq
 * @date 2019-05-30 13:52
 **/
public class EdgeWeightedDigraph {
    private final int V;
    private int E;
    private LinkedList<DirectiedEdge>[] adj;

    public EdgeWeightedDigraph(int v){
        this.V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public EdgeWeightedDigraph(In in){
        this(in.readInt());
        int e = in.readInt();
        for (int i = 0; i < e; i++) {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            addEdge(new DirectiedEdge(v, w, weight));
        }
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    public void addEdge(DirectiedEdge e){
        adj[e.from()].add(e);
        E++;
    }

    public Iterable<DirectiedEdge> adj(int v){
        return adj[v];
    }

    public Iterable<DirectiedEdge> edges(){
        LinkedList<DirectiedEdge> edges = new LinkedList<>();
        for (int v = 0; v < V; v++) {
            for (DirectiedEdge e : adj[v]) {
                edges.add(e);
            }
        }
        return edges;
    }


}
