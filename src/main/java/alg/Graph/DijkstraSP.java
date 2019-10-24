package alg.Graph;


import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;

import java.util.Stack;

/**
 * @program: algorithms
 * @description:
 * @author: wxq
 * @date 2019-05-31 10:42
 **/
public class DijkstraSP {
    private DirectiedEdge[] edgeTo;
    private double[] distTo;
    private IndexMinPQ<Double> pq;

    public DijkstraSP(EdgeWeightedDigraph G, int s){
        distTo = new double[G.V()];
        edgeTo = new DirectiedEdge[G.V()];
        pq = new IndexMinPQ<>(G.V());

        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = Double.MAX_VALUE;
        }

        pq.insert(s, 0.0);
        edgeTo[s] = null;
        distTo[s] = 0;

        while (!pq.isEmpty()){
            relax(G, pq.delMin());
        }
    }

    private void relax(EdgeWeightedDigraph G, int v){
        for (DirectiedEdge e : G.adj(v)) {
            int w = e.to();
            if(distTo[v] + e.weight() < distTo[w]){
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                if (pq.contains(w)) pq.change(w, distTo[w]);
                else pq.insert(w, distTo[w]);
            }
        }
    }

    public double distTo(int v){
        return distTo[v];
    }

    public boolean hashPathTo(int v){
        return distTo[v] < Double.MAX_VALUE;
    }

    public Iterable<DirectiedEdge> pathTo(int v){
        if (!hashPathTo(v)) {
            return null;
        }
        Stack<DirectiedEdge> stack = new Stack<>();
        for (DirectiedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]){
            stack.push(e);
        }
        return stack;
    }

    public static void main(String[] args) {
        String tinyEWG_ForSP = "src/main/java/alg/Graph/tinyEWG_ForSP.txt";
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In(tinyEWG_ForSP));
        DijkstraSP dijkstraSP = new DijkstraSP(G, 0);
        for (DirectiedEdge directiedEdge : dijkstraSP.pathTo(1)) {
            System.out.println(directiedEdge);
        }
    }
}
