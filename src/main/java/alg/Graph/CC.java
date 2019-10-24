package alg.Graph;

/**
 * @program: algorithms
 * @description: 使用深度优先搜索找出图中的所有连通分量 p349
 * @author: wxq
 * @date 2019-05-23 09:53
 **/
public class CC {
    private boolean[] marked;
    private int[] id;
    private int count;

    public CC(Graph G){
        marked = new boolean[G.V()];
        id = new int[G.V()];
        count = 0;
        for (int i = 0; i < G.V(); i++) {
            if (!marked[i]){
                //深度优先搜索
                dfs(G, i);
                count++;

            }
        }
    }

    private void dfs(Graph G, int v){
        marked[v] = true;
        id[v] = count;
        for (Integer w : G.adj(v)) {
            if(!marked[w]){
                dfs(G, w);
            }
        }
    }

    public boolean connected(int v, int w){
        return id[v] == id[w];
    }

    public int id(int v){ return id[v]; }

    public int count(){
        return count;
    }
}
