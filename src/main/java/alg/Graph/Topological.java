package alg.Graph;

/**
 * @program: algorithms
 * @description: 拓扑排序
 * @author: wxq
 * @date 2019-05-28 10:17
 **/
public class Topological {
    private Iterable<Integer> order;

    public Topological(Digraph G){
        DirectedCycle directedCycle = new DirectedCycle(G);
        if (!directedCycle.hasCycle()) {
            DepthFirstOrder depthFirstOrder = new DepthFirstOrder(G);
            order = depthFirstOrder.reversePost();
        }
    }

    public Topological(EdgeWeightedDigraph G){
        // 加权有向图寻找是否有环, 原理同 有向图寻找环

        //如果不存在环, 深度优先搜索的逆后序遍历就是其拓扑排序

    }

    public Iterable<Integer> order(){
        return order;
    }

    public boolean isDAG(){
        return order != null;
    }
}
