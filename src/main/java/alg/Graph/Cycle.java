package alg.Graph;

import edu.princeton.cs.algs4.In;

/**
 * @program: algorithms
 * @description: 判断G是否是无环图 p352
 * @author: wxq
 * @date 2019-05-23 10:25
 **/
public class Cycle {
    private boolean hasCycle;
    private boolean[] marked;

    public Cycle(Graph G){
        marked = new boolean[G.V()];
        for (int i = 0; i < G.V(); i++) {
            if (!marked[i]){
                dfs(G, i, i);
            }
        }
    }

    private void dfs(Graph G, int v, int s){
        marked[v] = true;
        for (Integer w : G.adj(v)) {
            if (!marked[w]){
                dfs(G, w, v);
            }else if (w != s){
                hasCycle = true;
            }
        }
    }

    public boolean hasCycle(){
        return hasCycle;
    }

    public static void main(String[] args) {
        String tinyGPath = "src/main/java/alg/Graph/tinyG.txt";
        String tinyCGPath = "src/main/java/alg/Graph/tinyCG.txt";
        String mediumGURL = "src/main/java/alg/Graph/mediumG.txt";

        Graph tinyG = new Graph(new In(tinyGPath));
        Graph tinyCG = new Graph(new In(tinyCGPath));
        Graph mediumG = new Graph(new In(mediumGURL));

        Cycle cycle = new Cycle(tinyG);
        System.out.println(cycle.hasCycle);
    }
}
