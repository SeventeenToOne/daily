package alg.Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @program: algorithms
 * @description: 广度优先遍历查找图中路径
 * @author: wxq
 * @date 2019-05-22 10:57
 **/
public class BreadthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public BreadthFirstPaths(Graph G, int s){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    private void bfs(Graph G, int s){
        marked[s] = true;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(s);

        while (!queue.isEmpty()){
            int v = queue.remove();
            for (Integer w : G.adj(v)) {
                if (!marked[w]){
                    marked[w] = true;
                    edgeTo[w] = v;
                    queue.addLast(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if (!hasPathTo(v)) return null;
        LinkedList<Integer> stack = new LinkedList<>();
        for (int x = v; x != s ; x = edgeTo[x]) {
            stack.addFirst(x);
        }
        stack.addFirst(s);
        return stack;
    }
}
