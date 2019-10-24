package alg.Graph;

import edu.princeton.cs.algs4.In;

/**
 * @program: algorithms
 * @description:
 * @author: wxq
 * @date 2019-05-31 11:07
 **/
public class DijkstraAllPairsSP {
    private DijkstraSP[] all;

    public DijkstraAllPairsSP(EdgeWeightedDigraph G){
        all = new DijkstraSP[G.V()];
        for (int i = 0; i < G.V(); i++) {
            all[i] = new DijkstraSP(G, i);
        }
    }

    public Iterable<DirectiedEdge> path(int s, int t){
        return all[s].pathTo(t);
    }

    public double dist(int s, int t){
        return all[s].distTo(t);
    }

    public static void main(String[] args) {
        String tinyEWG_ForSP = "src/main/java/alg/Graph/tinyEWG_ForSP.txt";
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In(tinyEWG_ForSP));
        DijkstraAllPairsSP all = new DijkstraAllPairsSP(G);
        for (DirectiedEdge directiedEdge : all.path(0, 5)) {
            System.out.println(directiedEdge);
        }
    }
}
