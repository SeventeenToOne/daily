package alg.Graph;

import edu.princeton.cs.algs4.In;

import java.util.LinkedList;

/**
 * @program: algorithms
 * @description:
 * @author: wxq
 * @date 2019-05-29 10:16
 **/
public class EdgeWeightedGraph {
    private final int V;
    private int E;
    private LinkedList<Edge>[] adj;

    public EdgeWeightedGraph(int v){
        this.V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public EdgeWeightedGraph(In in){
        this(in.readInt());
        int e = in.readInt();
        for (int i = 0; i < e; i++) {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            addEdge(new Edge(v, w, weight));
        }
    }

    public void addEdge(Edge edge){
        int v = edge.either(), w = edge.other(v);
        adj[v].add(edge);
        adj[w].add(edge);
        E++;
    }

    public Iterable<Edge> adj(int v){
        return adj[v];
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    public Iterable<Edge> edges(){
        LinkedList<Edge> edgeList = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            for (Edge e : adj(i)) {
                if (e.other(i) > i) edgeList.add(e);
            }
        }
        return edgeList;
    }

    public static void main(String[] args) {
        String mediumEWG = "src/main/java/alg/Graph/mediumEWG.txt";
        EdgeWeightedGraph edgeWeightedGraph = new EdgeWeightedGraph(new In(mediumEWG));
        System.out.println(edgeWeightedGraph.E());
    }
}
