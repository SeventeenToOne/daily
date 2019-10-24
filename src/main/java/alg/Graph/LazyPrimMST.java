package alg.Graph;

import edu.princeton.cs.algs4.In;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @program: algorithms
 * @description: 延时删除的prim算法
 * @author: wxq
 * @date 2019-05-30 10:18
 **/
public class LazyPrimMST {
    private boolean[] marked ;
    private LinkedList<Edge> mst;
    private PriorityQueue<Edge> pq;

    public LazyPrimMST(EdgeWeightedGraph G){
        pq = new PriorityQueue<>();
        mst = new LinkedList<>();
        marked = new boolean[G.V()];

        // 判断当前图是否是连通图, ex. 深度优先搜索遍历所有节点

        //
        visit(G, 0);
        while (!pq.isEmpty()){
            Edge e = pq.poll();
            int v = e.either(), w = e.other(v);
            if (marked[v] && marked[w]) continue;
            mst.offer(e);
            if (!marked[v]) visit(G, v);
            if (!marked[w]) visit(G, w);
        }
    }

    private void visit(EdgeWeightedGraph G, int v){
        marked[v] = true;
        for (Edge edge : G.adj(v)) {
            if (!marked[edge.other(v)]) pq.add(edge);
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
    }

}
