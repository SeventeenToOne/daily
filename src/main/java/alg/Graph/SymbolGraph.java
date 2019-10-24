package alg.Graph;

import edu.princeton.cs.algs4.In;

import java.util.HashMap;

/**
 * @program: algorithms
 * @description: 符号图 p356
 * @author: wxq
 * @date 2019-05-24 10:17
 **/
public class SymbolGraph {
    private HashMap<String, Integer> st;
    private String[] keys;
    private Graph G;

    public SymbolGraph(String stream, String sp){
        st = new HashMap<>();
        In in = new In(stream);

        while (in.hasNextLine()){
            String[] a = in.readLine().split(sp);
            for (String s : a) {
                if (!st.containsKey(s)){
                    st.put(s, st.size());
                }
            }
        }
        keys = new String[st.size()];
        for (String s : st.keySet()) {
            keys[st.get(s)] = s;
        }

        G = new Graph(st.size());
        in = new In(stream);
        while (in.hasNextLine()){
            String[] a = in.readLine().split(sp);
            int v = st.get(a[0]);
            for (int i = 1; i < a.length; i++) {
                G.addEdge(v, st.get(a[i]));
            }
        }
    }

    public boolean contains(String s){
        return st.containsKey(s);
    }

    public int index(String s){
        return st.get(s);
    }

    public String name(int v){
        return keys[v];
    }

    public Graph G(){
        return G;
    }

    public static void main(String[] args) {
        String moviesPath = "src/main/java/alg/Graph/movies.txt";
        SymbolGraph symbolGraph = new SymbolGraph(moviesPath, "/");
        System.out.println(symbolGraph.G().V());
        TwoColor twoColor = new TwoColor(symbolGraph.G());
        System.out.println(twoColor.isBipartite());
    }
}
