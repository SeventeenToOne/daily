package alg.Graph;

import java.util.LinkedList;

/**
 * @program: algorithms
 * @description: 使用深度优先搜索查找图中的路径 P343
 * @author: wxq
 * @date 2019-05-22 09:57
 **/
public class DepthFirstPaths {
    private boolean[] marked; // 顶点是否调用过dfs()
    private int[] edgeTo; // 从起点到一个顶点的一支路径路径上的最后一个顶点
    private final int s; // start

    public DepthFirstPaths(Graph G, int s){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    private void dfs(Graph G, int v){
        marked[v] = true;
        for (Integer w : G.adj(v)) {
            if (!marked[w]){
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if (!hasPathTo(v)) return null;
        LinkedList<Integer> q = new LinkedList<>();
        for (int w = v; w != s; w = edgeTo[w]){
            q.addFirst(w);
        }
        q.addFirst(s);
        return q;
    }
}
