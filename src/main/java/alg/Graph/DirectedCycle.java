package alg.Graph;

import edu.princeton.cs.algs4.In;

import java.util.Stack;

/**
 * @program: algorithms
 * @description: 寻找有向环 P372 关键:使用栈保存访问的节点判断环,不能单纯的依靠
 * @author: wxq
 * @date 2019-05-27 11:29
 **/
public class DirectedCycle {
    private int[] edgeTo;
    private Stack<Integer> cycle;
    private boolean[] marked;
    private boolean[] onStack;

    public DirectedCycle(Digraph G){
        onStack = new boolean[G.V()];
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];

        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]){
                dfs(G, s);
            }
        }

    }

    private void dfs(Digraph G, int v){
        marked[v] = true;
        onStack[v] = true;

        for (Integer w : G.adj(v)) {
            if (cycle != null) return;

            if (!marked[w]){
                edgeTo[w] = v;
                dfs(G, w);
            }else if (onStack[w]){
                cycle = new Stack<>();
                for (int x = v; x != w; x = edgeTo[x]){
                    cycle.push(x);
                }

                cycle.push(w);
                cycle.push(v);
            }
        }

        onStack[v] = false;
    }

    public boolean hasCycle(){
        return cycle != null;
    }

    public Iterable<Integer> cycle(){
        return cycle;
    }

    public static void main(String[] args) {
        String tinyDG = "src/main/java/alg/Graph/tinyDG.txt";
        Digraph digraph = new Digraph(new In(tinyDG));
        DirectedCycle directedCycle = new DirectedCycle(digraph);
        if (directedCycle.hasCycle()){
            for (Integer w : directedCycle.cycle) {
                System.out.print(w + " ");
            }
            System.out.println();
        }
    }

}
