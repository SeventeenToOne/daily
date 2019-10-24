package alg.Graph;

import edu.princeton.cs.algs4.In;

import java.util.Stack;

/**
 * @program: algorithms
 * @description: 图双色问题, 是否可以分为二分图
 * @author: wxq
 * @date 2019-05-23 10:41
 **/
public class TwoColor {
    private boolean[] marked;
    private boolean[] color;
    private boolean isTwoColorable = true;

    public TwoColor(Graph G){
        marked = new boolean[G.V()];
        color = new boolean[G.V()];

        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]){
                dfsNonRecusive(G, s);
            }
        }
    }

    private void dfsNonRecusive(Graph G, int v){
        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        marked[v] = true;
        while (!stack.isEmpty()){
            int w = stack.pop();
            marked[w] = true;
            for (Integer x : G.adj(w)) {
                if(!marked[x]){
                    color[x] = !color[w];
                    stack.push(x);
                }else if (color[w] == color[x]){
                    isTwoColorable = false;
                }
            }
        }
    }

    private void dfs(Graph G, int v){
        marked[v] = true;
        for (Integer w : G.adj(v)) {
            if (!marked[w]){
                color[w] = !color[v];
                dfs(G, w);
            }else if (color[w] == color[v]){
                isTwoColorable = false;
            }
        }
    }

    public boolean isBipartite(){ return isTwoColorable; }

    public static void main(String[] args) {
        String tinyGPath = "src/main/java/alg/Graph/tinyG.txt";
        String tinyCGPath = "src/main/java/alg/Graph/tinyCG.txt";
        String mediumGURL = "src/main/java/alg/Graph/mediumG.txt";
        String towColorPath = "src/main/java/alg/Graph/twoColorG.txt";

        Graph tinyG = new Graph(new In(tinyGPath));
        Graph tinyCG = new Graph(new In(tinyCGPath));
        Graph mediumG = new Graph(new In(mediumGURL));
        Graph towColorG = new Graph(new In(towColorPath));

        TwoColor twoColor1 = new TwoColor(tinyG);
        TwoColor twoColor2 = new TwoColor(tinyCG);
        TwoColor twoColor3 = new TwoColor(mediumG);
        TwoColor twoColor4 = new TwoColor(towColorG);

        System.out.println(twoColor1.isBipartite());
        System.out.println(twoColor2.isBipartite());
        System.out.println(twoColor3.isBipartite());
        System.out.println(twoColor4.isBipartite());
    }
}
