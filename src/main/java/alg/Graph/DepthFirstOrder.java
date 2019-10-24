package alg.Graph;

import edu.princeton.cs.algs4.In;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @program: algorithms
 * @description: 深度优先搜索的顶点排序
 * @author: wxq
 * @date 2019-05-28 09:58
 **/
public class DepthFirstOrder {
    private boolean[] marked;
    private Queue<Integer> pre;
    private Queue<Integer> post;
    private Stack<Integer> reversePost;

    public DepthFirstOrder(Digraph G){
        marked = new boolean[G.V()];
        pre = new LinkedList<>();
        post = new LinkedList<>();
        reversePost = new Stack<>();

        for (int i = 0; i < G.V(); i++) {
            if (!marked[i]){
                dfs(G, i);
            }
        }
    }

    private void dfs(Digraph G, int v){
        marked[v] = true;
        pre.offer(v);

        for (Integer w : G.adj(v)) {
            if (!marked[w]){
                dfs(G, w);
            }
        }

        post.offer(v);
        reversePost.push(v);
    }

    public Iterable<Integer> post(){
        return post;
    }

    public Iterable<Integer> pre(){
        return pre;
    }

    public Iterable<Integer> reversePost(){
        return reversePost;
    }

}
