package bishi.huawei2019;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * @program: algorithms
 * @description:
 * @author: wxq
 * @date 2019-07-31 19:43
 **/
//public class Main2 {
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//
//    }
//}
//
//public class SymbolDigraph {
//    private HashMap<String, Integer> st;  // string -> index
//    private String[] keys;           // index  -> string
//    private Digraph graph;           // the underlying digraph
//
//
//    public SymbolDigraph(Scanner scan, String delimiter) {
//        st = new HashMap<String, Integer>();
//
//        In in = new In(filename);
//        while (in.hasNextLine()) {
//            String[] a = in.readLine().split(delimiter);
//            for (int i = 0; i < a.length; i++) {
//                if (!st.contains(a[i]))
//                    st.put(a[i], st.size());
//            }
//        }
//
//
//        keys = new String[st.size()];
//        for (String name : st.keys()) {
//            keys[st.get(name)] = name;
//        }
//
//
//        graph = new Digraph(st.size());
//        in = new In(filename);
//        while (in.hasNextLine()) {
//            String[] a = in.readLine().split(delimiter);
//            int v = st.get(a[0]);
//            for (int i = 1; i < a.length; i++) {
//                int w = st.get(a[i]);
//                graph.addEdge(v, w);
//            }
//        }
//    }
//
//
//    public boolean contains(String s) {
//        return st.contains(s);
//    }
//
//
//    public int index(String s) {
//        return st.get(s);
//    }
//
//
//    public int indexOf(String s) {
//        return st.get(s);
//    }
//
//
//    public String name(int v) {
//        validateVertex(v);
//        return keys[v];
//    }
//
//    public String nameOf(int v) {
//        validateVertex(v);
//        return keys[v];
//    }
//
//    public Digraph G() {
//        return graph;
//    }
//
//
//    public Digraph digraph() {
//        return graph;
//    }
//
//
//    private void validateVertex(int v) {
//        int V = graph.V();
//        if (v < 0 || v >= V)
//            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
//    }
//
//
//
//}
//
//class Digraph {
//    private final int V;
//    private int E;
//    private ArrayList<Integer>[] adj;
//
//    public Digraph(int v){
//        this.V = v;
//        adj = new ArrayList[v];
//        for (int i = 0; i < adj.length; i++) {
//            adj[i] = new ArrayList<>();
//        }
//    }
//
//    public int V(){
//        return V;
//    }
//
//    public int E(){
//        return E;
//    }
//
//    public Iterable<Integer> adj(int v){
//        return adj[v];
//    }
//
//    public void addEdge(int v, int w){
//        adj[v].add(w);
//        E++;
//    }
//    public Digraph reverse(){
//        Digraph g = new Digraph(V);
//        for (int i = 0; i < V; i++) {
//            for (Integer v : adj[i]) {
//                g.addEdge(v, i);
//            }
//        }
//
//        return g;
//    }
//
//
//
//}
//
//class DirectedCycle {
//    private int[] edgeTo;
//    private Stack<Integer> cycle;
//    private boolean[] marked;
//    private boolean[] onStack;
//
//    public DirectedCycle(Digraph G){
//        onStack = new boolean[G.V()];
//        marked = new boolean[G.V()];
//        edgeTo = new int[G.V()];
//
//        for (int s = 0; s < G.V(); s++) {
//            if (!marked[s]){
//                dfs(G, s);
//            }
//        }
//
//    }
//
//    private void dfs(Digraph G, int v){
//        marked[v] = true;
//        onStack[v] = true;
//
//        for (Integer w : G.adj(v)) {
//            if (cycle != null) return;
//
//            if (!marked[w]){
//                edgeTo[w] = v;
//                dfs(G, w);
//            }else if (onStack[w]){
//                cycle = new Stack<>();
//                for (int x = v; x != w; x = edgeTo[x]){
//                    cycle.push(x);
//                }
//
//                cycle.push(w);
//                cycle.push(v);
//            }
//        }
//
//        onStack[v] = false;
//    }
//
//    public boolean hasCycle(){
//        return cycle != null;
//    }
//
//    public Iterable<Integer> cycle(){
//        return cycle;
//    }
//
//    public static void main(String[] args) {
//        String tinyDG = "src/main/java/alg/Graph/tinyDG.txt";
//        Digraph digraph = new Digraph(new In(tinyDG));
//        DirectedCycle directedCycle = new DirectedCycle(digraph);
//        if (directedCycle.hasCycle()){
//            for (Integer w : directedCycle.cycle) {
//                System.out.print(w + " ");
//            }
//            System.out.println();
//        }
//    }
//
//}