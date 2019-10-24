package alg.Graph;

/**
 * @program: algorithms
 * @description: 深度优先搜索算法 P339
 * @author: wxq
 * @date 2019-05-21 16:17
 **/
public class DepthFirstSearch {
    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph G, int s){
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    public void dfs(Graph G, int v){
        marked[v] = true;
        count++;
        for (Integer w : G.adj(v)) {
            if (!marked[w]){
                dfs(G, w);
            }
        }
    }

    public boolean marked(int w){
        return marked[w];
    }

    public int count(){
        return count;
    }

}
