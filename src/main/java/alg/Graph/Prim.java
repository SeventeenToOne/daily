package alg.Graph;


import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.PrimMST;

import java.util.LinkedList;

/**
 * @program: algorithms
 * @description: 即时版本的Prime
 * @author: wxq
 * @date 2019-05-30 10:36
 **/
public class Prim {
    private Edge[] edgeTo;
    private double[] distTo;
    private boolean[] marked;
    private IndexMinPQ<Double> pq;

    public Prim(EdgeWeightedGraph G){
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        marked = new boolean[G.V()];
        pq = new IndexMinPQ<>(G.V());
        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = Double.MAX_VALUE;
        }


        distTo[0] = 0;
        pq.insert(0, 0.0);
        while (!pq.isEmpty()){
            visit(G, pq.delMin());
        }
    }

    private void visit(EdgeWeightedGraph G, int v){
        marked[v] = true;
        for (Edge edge : G.adj(v)) {
            int w = edge.other(v);
            if (marked[w]) continue;
            if (edge.weight() < distTo[w]){
                edgeTo[w] = edge;
                distTo[w] = edge.weight();
                if (pq.contains(w)) pq.change(w,  distTo[w]);
                else pq.insert(w,  distTo[w]);
            }
        }
    }

    public Iterable<Edge> edges(){
        LinkedList<Edge> mst = new LinkedList<Edge>();
        for (int v = 0; v < edgeTo.length; v++) {
            Edge e = edgeTo[v];
            if (e != null) {
                mst.add(e);
            }
        }
        return mst;
    }

    public static void main(String[] args) {
        String tinyEWG = "src/main/java/alg/Graph/tinyEWG.txt";
        EdgeWeightedGraph edgeWeightedGraph = new EdgeWeightedGraph(new In(tinyEWG));
        Prim prim = new Prim(edgeWeightedGraph);

        for (Edge edge : prim.edges()) {
            System.out.println(edge);
        }

        edu.princeton.cs.algs4.EdgeWeightedGraph edgeWeightedGraph1 = new edu.princeton.cs.algs4.EdgeWeightedGraph((new In(tinyEWG)));
        PrimMST primMST = new PrimMST(edgeWeightedGraph1);
        System.out.println();
        for (edu.princeton.cs.algs4.Edge edge : primMST.edges()) {
            System.out.println(edge);
        }

    }

}
///usr/lib/jvm/java-8-oracle/bin/java -javaagent:/home/lab421-w/idea/idea-IU-181.4668.68/lib/idea_rt.jar=38075:/home/lab421-w/idea/idea-IU-181.4668.68/bin -Dfile.encoding=UTF-8 -classpath /usr/lib/jvm/java-8-oracle/jre/lib/charsets.jar:/usr/lib/jvm/java-8-oracle/jre/lib/deploy.jar:/usr/lib/jvm/java-8-oracle/jre/lib/ext/cldrdata.jar:/usr/lib/jvm/java-8-oracle/jre/lib/ext/dnsns.jar:/usr/lib/jvm/java-8-oracle/jre/lib/ext/jaccess.jar:/usr/lib/jvm/java-8-oracle/jre/lib/ext/jfxrt.jar:/usr/lib/jvm/java-8-oracle/jre/lib/ext/localedata.jar:/usr/lib/jvm/java-8-oracle/jre/lib/ext/nashorn.jar:/usr/lib/jvm/java-8-oracle/jre/lib/ext/sunec.jar:/usr/lib/jvm/java-8-oracle/jre/lib/ext/sunjce_provider.jar:/usr/lib/jvm/java-8-oracle/jre/lib/ext/sunpkcs11.jar:/usr/lib/jvm/java-8-oracle/jre/lib/ext/zipfs.jar:/usr/lib/jvm/java-8-oracle/jre/lib/javaws.jar:/usr/lib/jvm/java-8-oracle/jre/lib/jce.jar:/usr/lib/jvm/java-8-oracle/jre/lib/jfr.jar:/usr/lib/jvm/java-8-oracle/jre/lib/jfxswt.jar:/usr/lib/jvm/java-8-oracle/jre/lib/jsse.jar:/usr/lib/jvm/java-8-oracle/jre/lib/management-agent.jar:/usr/lib/jvm/java-8-oracle/jre/lib/plugin.jar:/usr/lib/jvm/java-8-oracle/jre/lib/resources.jar:/usr/lib/jvm/java-8-oracle/jre/lib/rt.jar:/home/lab421-w/repository_java/githubs/dailyPractice/algorithms/target/classes:/home/lab421-w/repository_java/githubs/dailyPractice/algorithms/algs4.jar:/home/lab421-w/.m2/repository/commons-dbcp/commons-dbcp/1.4/commons-dbcp-1.4.jar:/home/lab421-w/.m2/repository/commons-pool/commons-pool/1.5.4/commons-pool-1.5.4.jar:/home/lab421-w/.m2/repository/com/moparisthebest/aptIn16/apt-mirror-api/0.2/apt-mirror-api-0.2.jar alg.Graph.Prim
//        1-7 0.19
//        0-2 0.26
//        2-3 0.17
//        4-5 0.35
//        5-7 0.28
//        6-2 0.40
//        0-7 0.16
//
//        1-7 0.19000
//        0-2 0.26000
//        2-3 0.17000
//        4-5 0.35000
//        5-7 0.28000
//        6-2 0.40000
//        0-7 0.16000
//
//        Process finished with exit code 0
