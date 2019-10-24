package alg.Graph;

/**
 * @program: algorithms
 * @description: 有向图的可达性
 * @author: wxq
 * @date 2019-05-27 09:36
 **/
public class DirectedDFS {
    private boolean[] marked;

    public DirectedDFS(Digraph G, int s){
        marked = new boolean[G.V()];
        dfs(G, s);
    }


    private void dfs(Digraph G, int v){
        marked[v] = true;
        for (Integer w : G.adj(v)) {
            if (!marked[w]){
                dfs(G, w);
            }
        }
    }


    public static void main(String[] args) {

    }
}
