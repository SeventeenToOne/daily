package alg.Graph;

import edu.princeton.cs.algs4.In;

/**
 * @program: algorithms
 * @description: 强连通分量 p380 有向图
 * @author: wxq
 * @date 2019-05-28 10:45
 **/
public class KosarajuSCC {
    private boolean[] marked;
    private int[] id;
    private int count;

    public KosarajuSCC(Digraph G ){
        marked = new boolean[G.V()];
        id = new int[G.V()];

        DepthFirstOrder depthFirstOrder = new DepthFirstOrder(G.reverse());
        for (Integer s : depthFirstOrder.reversePost()) {
            if (!marked[s]){
                count++;
                dfs(G, s);
            }
        }
    }

    private void dfs(Digraph G, int v){
        marked[v] = true;
        id[v] = count;

        for (Integer w : G.adj(v)) {
            if (!marked[w]){
                dfs(G, w);
            }

        }
    }

    public boolean stronglyConnected(int v, int w){
        return id[v] == id[w];
    }

    public int id(int v){
        return id[v];
    }

    public int count(){
        return count;
    }

    public static void main(String[] args) {
        String tinyDG = "src/main/java/alg/Graph/tinyDG.txt";
        Digraph digraph = new Digraph(new In(tinyDG));
        KosarajuSCC scc = new KosarajuSCC(digraph);
        System.out.println(scc.count());
        for (int i = 1; i <=scc.count(); i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < digraph.V(); j++) {
                if (scc.id(j) == i) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }

    }
}
