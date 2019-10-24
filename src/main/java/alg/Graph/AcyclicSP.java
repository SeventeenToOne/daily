package alg.Graph;

/**
 * @program: algorithms
 * @description: 无环加权有向图的最短路径算法
 * @author: wxq
 * @date 2019-05-31 12:29
 **/
public class AcyclicSP {
    private DirectiedEdge[] edgeTo;
    private double[] distTo;

    public AcyclicSP(EdgeWeightedDigraph G, int s){
        edgeTo = new DirectiedEdge[G.V()];
        distTo = new double[G.V()];

        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = Double.MAX_VALUE;
        }
        distTo[s] = 0.0;
        // 对有向图的拓扑排序,待补充
        Topological top = new Topological(G);
        for (Integer v : top.order()) {
            relax(G, v);
        }
    }

    private void relax(EdgeWeightedDigraph G, int v){
        for (DirectiedEdge e : G.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()){
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
            }
        }
    }
}
