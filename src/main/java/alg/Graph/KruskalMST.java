package alg.Graph;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.UF;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @program: algorithms
 * @description:
 * @author: wxq
 * @date 2019-05-30 11:35
 **/
public class KruskalMST {
    private LinkedList<Edge> mst;

    public KruskalMST(EdgeWeightedGraph G){
        mst = new LinkedList<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (Edge edge : G.edges()) {
            pq.add(edge);
        }
        UF uf = new UF(G.V());

        while (!pq.isEmpty()){
            Edge e = pq.poll();
            int v = e.either(), w = e.other(v);
            if (uf.connected(w, v)) continue;
            uf.union(w, v);
            mst.add(e);
        }
    }

    public Iterable<Edge> edges(){
        return mst;
    }

    public double weight(){
        double weight = 0;
        for (Edge edge : mst) {
            weight += edge.weight();
        }
        return weight;
    }

    public static void main(String[] args) {
        String tinyEWG = "src/main/java/alg/Graph/tinyEWG.txt";
        EdgeWeightedGraph edgeWeightedGraph = new EdgeWeightedGraph(new In(tinyEWG));
        LazyPrimMST lazyPrimMST = new LazyPrimMST(edgeWeightedGraph);
        for (Edge edge : lazyPrimMST.edges()) {
            System.out.println(edge);
        }

        KruskalMST kruskalMST = new KruskalMST(edgeWeightedGraph);

        System.out.println();
        for (Edge edge : kruskalMST.edges()) {
            System.out.println(edge);
        }

        System.out.println("LazyPrimMST : " + lazyPrimMST.weight() + "\nkruskalMST : " + kruskalMST.weight());
    }
}
